package csc340.group3.ShowHunter.provider.venues;

import csc340.group3.ShowHunter.provider.shows.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import csc340.group3.ShowHunter.provider.shows.Shows;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @Autowired
    private ShowsService showsService;

    @GetMapping("/all")
    public String listVenues(Model model) {
        List<Venue> venues = venueService.getAllVenues();
        model.addAttribute("venues", venues);
        return "venue-list";
    }

    @GetMapping("/{id}")
    public String getOneVenue(@PathVariable int id, Model model) {
        Venue venue = venueService.getVenueById(id);
        model.addAttribute("venue", venue);
        model.addAttribute("shows", venue.getShows());
        return "venue-view";
    }

    @GetMapping("/delete/{id}")
    public String deleteVenueById(@PathVariable int id) {
        venueService.deleteVenueById(id);
        return "redirect:/venues/all";
    }

    @GetMapping("/edit/{id}")
    public String editVenueForm(@PathVariable int id, Model model) {
        Venue venue = venueService.getVenueById(id);
        model.addAttribute("venue", venue);
        return "edit-venue";
    }

    @PostMapping("/edit/{id}")
    public String updateVenue(@PathVariable int id, Venue venue) {
        venue.setId(id);
        venueService.addVenue(venue);
        return "redirect:/venues/" + id;
    }

    @GetMapping("/new")
    public String createVenueForm() {
        return "create-venue";
    }

    @PostMapping("/new")
    public String createVenue(@ModelAttribute Venue venue) {
        venueService.addVenue(venue);
        return "redirect:/venues/" + venue.getId();
    }

    @GetMapping("/{id}/add-show")
    public String showAddForm(@PathVariable int id, Model model) {
        Venue venue = venueService.getVenueById(id);
        model.addAttribute("venue", venue);
        model.addAttribute("show", new Shows());
        return "add-show";
    }

    @PostMapping("/{id}/add-show")
    @Transactional
    public String saveShow(@PathVariable int id, @ModelAttribute Shows show) {
        Shows savedShow = showsService.createShow(show, id);
        return "redirect:/venues/" + id;
    }

}
