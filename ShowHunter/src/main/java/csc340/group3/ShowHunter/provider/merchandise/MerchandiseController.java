package csc340.group3.ShowHunter.provider.merchandise;

import csc340.group3.ShowHunter.provider.shows.Shows;
import csc340.group3.ShowHunter.provider.shows.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Controller
@Transactional
public class MerchandiseController {

    @Autowired
    private MerchandiseService merchandiseService;
    @Autowired
    private ShowsService showsService;

    @GetMapping("/merch/{id}")
    public String getMerch(@PathVariable int id, Model model) {
        Merchandise merch = merchandiseService.getMerchById(id);
        model.addAttribute("merch", merch);
        return "merch-view";
    }

    @GetMapping("/merch/update/{id}")
    public String editMerchForm(@PathVariable int id, Model model) {
        Merchandise merch = merchandiseService.getMerchById(id);
        model.addAttribute("merch", merch);
        return "edit-merch";
    }

    @PostMapping("/merch/update/{id}")
    public String updateMerch(@PathVariable int id, @ModelAttribute Merchandise updatedMerch) {
        Merchandise existingMerch = merchandiseService.getMerchById(id);
        Shows show = existingMerch.getShow();
        
        existingMerch.setImage(updatedMerch.getImage());
        existingMerch.setTitle(updatedMerch.getTitle());
        existingMerch.setPrice(updatedMerch.getPrice());
        existingMerch.setDescription(updatedMerch.getDescription());
        
        merchandiseService.addMerch(existingMerch);
        return "redirect:/shows/" + show.getId();
    }

    @GetMapping("/merch/delete/{id}")
    public String deleteMerchById(@PathVariable int id) {
        Merchandise merch = merchandiseService.getMerchById(id);
        Shows show = merch.getShow();
        int showId = show.getId();
        merchandiseService.deleteMerch(id);
        return "redirect:/shows/" + showId;
    }
}
