package csc340.group3.ShowHunter.provider.shows;
import csc340.group3.ShowHunter.provider.venues.Venue;

import csc340.group3.ShowHunter.provider.venues.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ShowsController {

    @Autowired
    private ShowsService showsService;
    @Autowired
    private VenueService venueService;

    @GetMapping("shows/{id}")
    public String getOneShow(@PathVariable int id, Model model) {
        Shows show = showsService.getShowByID(id).orElse(null);
        model.addAttribute("show", show);
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


    @GetMapping("/venues/add-show/{venueId}/")
    public String addShowForm(@PathVariable int venueId, Model model) {
        Venue venue = venueService.getVenueById(venueId); // Fetch the venue
        model.addAttribute("venue", venue); // Pass the venue to the view
        return "add-show"; // Render the add-show.html form
    }
}
