package csc340.group3.ShowHunter.provider.shows;
import csc340.group3.ShowHunter.provider.merchandise.Merchandise;
import csc340.group3.ShowHunter.provider.merchandise.MerchandiseService;
import csc340.group3.ShowHunter.provider.venues.Venue;

import csc340.group3.ShowHunter.provider.venues.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Controller
public class ShowsController {

    @Autowired
    private ShowsService showsService;
    @Autowired
    private VenueService venueService;
    @Autowired
    private MerchandiseService merchandiseService;

    @GetMapping("shows/{id}")
    public String getOneShow(@PathVariable int id, Model model) {
        Shows show = showsService.getShowByID(id).orElse(null);
        model.addAttribute("show", show);
        assert show != null;
        model.addAttribute("merch", show.getMerchandiseList());
        return "show-view";
    }

    @GetMapping("shows/edit/{id}")
    public String editShowForm(@PathVariable int id, Model model) {
        Shows show = showsService.getShowByID(id).orElse(null);
        model.addAttribute("show", show);
        model.addAttribute("venues", venueService.getAllVenues());
        return "edit-show";
    }

    @PostMapping("/shows/edit/{id}")
    public String updateShow(@PathVariable int id, @ModelAttribute Shows show, @RequestParam int venueId) {
        Venue venue = venueService.getVenueById(venueId);
        show.setId(id);
        show.setVenue(venue);
        showsService.addShow(show);
        return "redirect:/shows/{id}";
    }

    @GetMapping("/shows/delete/{id}")
    public String deleteShow(@PathVariable int id) {
        Shows t = showsService.getShowByID(id).orElse(null);
        Venue temp2 = t.getVenue();
        int vid = temp2.getId();
        showsService.deleteShowById(id);
        return "redirect:/venues/" + vid;
    }

    @GetMapping("/shows/{id}/add-merch")
    public String addMerchForm(@PathVariable int id, Model model) {
        Shows show = showsService.getShowByID(id).orElse(null);
        model.addAttribute("show", show);
        model.addAttribute("merch", new Merchandise());
        return "create-merch";
    }

    @PostMapping("/shows/{id}/add-merch")
    @Transactional
    public String saveMerch(@PathVariable int id, @ModelAttribute Merchandise merch) {
        Shows show = showsService.getShowByID(id).orElse(null);
        assert show != null;
        merch.setShow(show);
        merchandiseService.addMerch(merch);
        return "redirect:/shows/" + id;
    }

}
