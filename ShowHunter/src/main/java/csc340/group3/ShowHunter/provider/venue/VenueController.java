package csc340.group3.ShowHunter.provider.venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping("/all")
    public List<Venue> getAllVenues(){
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public Optional<Venue> getOneVenue(@PathVariable int id) {
        return venueService.getVenueById(id);
    }

    @PostMapping("/new")
    public List<Venue> addVenue(@RequestBody Venue venue) {
        venueService.addVenue(venue);
        return venueService.getAllVenues();
    }
    
    
    @PutMapping("/update/{id}")
    public Optional<Venue> updateVenue(@PathVariable int id, @RequestBody Venue venue) {
        venueService.updateVenue(id, venue);
        return venueService.getVenueById(id);
    }

    @DeleteMapping("delete/{id}")
    public List<Venue> deleteVenueById(@PathVariable int id) {
        venueService.deleteVenueById(id);
        return venueService.getAllVenues();
    }


}