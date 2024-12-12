package csc340.group3.ShowHunter.provider.venues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public List<Venue> getAllVenues(){
        return venueRepository.findAll();
    }

    public Venue getVenueById(int id) {
        return venueRepository.findById(id).orElse(null);
    }

    public void addVenue(Venue venue){
        venueRepository.save(venue);
    }

    public void updateVenue(int id, Venue venue){
        Venue existing = getVenueById(id);
        venue.setShows(existing.getShows());
        venueRepository.save(venue);
    }

    public void deleteVenueById(int id){
        venueRepository.deleteById(id);
    }
}