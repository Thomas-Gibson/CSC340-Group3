package csc340.group3.ShowHunter.provider.merchandise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MerchandiseController {

    @Autowired
    private MerchandiseService merchandiseService;


    @GetMapping("/merch/{id}")
    public String getMerch(@PathVariable int id, Model model){
        Merchandise merch = merchandiseService.getMerchById(id);
        model.addAttribute("merch", merch);
        return "a";
    }

    @GetMapping("/new")
    public String addMerch(){
        return "a";
    }

    @GetMapping("/merch/update/{id}")
    public String editMerchForm(@PathVariable int id, Model model){
        Merchandise merch = merchandiseService.getMerchById(id);
        model.addAttribute("merch", merch);
        return "a";
    }

    @PostMapping("/merch/update/{id}")
    public String updateMerch(@PathVariable int id, @ModelAttribute Merchandise merch){
        merch.setId(id);
        merchandiseService.addMerch(merch);
        return "a";
    }

    @GetMapping("/merch/delete/{id}")
    public String deleteMerchById(@PathVariable int id){
        merchandiseService.deleteMerch(id);
        return "a";
    }
}
