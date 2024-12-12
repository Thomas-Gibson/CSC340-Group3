package csc340.group3.ShowHunter.provider.shows;

import csc340.group3.ShowHunter.provider.venues.Venue;
import csc340.group3.ShowHunter.provider.venues.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShowsService {

    @Autowired
    private csc340.group3.ShowHunter.provider.shows.ShowsRepository showsRepository;
    @Autowired
    private VenueRepository venueRepository;

    @Transactional
    public Shows createShow(Shows show, int venueId) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found"));
        
        Shows newShow = new Shows();
        newShow.setName(show.getName());
        newShow.setDescription(show.getDescription());
        newShow.setImage(show.getImage());
        newShow.setTicket(show.getTicket());
        newShow.setTitle(show.getTitle());
        newShow.setVenue(venue);
        
        Shows savedShow = showsRepository.save(newShow);
        venue.getShows().add(savedShow);
        venueRepository.save(venue);
        
        return savedShow;
    }

    @Transactional
    public Shows updateShow(int id, Shows show) {
        Shows existingShow = showsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        
        existingShow.setName(show.getName());
        existingShow.setDescription(show.getDescription());
        existingShow.setImage(show.getImage());
        existingShow.setTicket(show.getTicket());
        existingShow.setTitle(show.getTitle());
        // Preserve the existing venue relationship
        
        return showsRepository.save(existingShow);
    }

    public List<Shows> getShowsByVenueID(int id) {
        return showsRepository.findByVenueId(id);
    }

    public Optional<Shows> getShowByID(int id) {
        return showsRepository.findById(id);
    }

    public void deleteShowById(int id){
        showsRepository.deleteById(id);
    }


}