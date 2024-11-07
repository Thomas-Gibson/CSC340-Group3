package csc340.group3.ShowHunter.provider.shows;

import csc340.group3.ShowHunter.provider.venue.Venue;
import csc340.group3.ShowHunter.provider.venue.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowsService {

    @Autowired
    private csc340.group3.ShowHunter.provider.shows.ShowsRepository showsRepository;
    @Autowired
    private VenueRepository venueRepository;

    public List<Shows> getAllShows() {
        return showsRepository.findAll();
    }

    public Optional<Shows> getShowByID(int id) {
        return showsRepository.findById(id);
    }

//    public Shows addShow(int venueId, Shows showDetails) {
//        Venue venue = venueRepository.findById(venueId);
//        showDetails.setVenue(venue);
//        return showsRepository.save(showDetails);
//    }

    public void addShow(Shows show){
        showsRepository.save(show);
    }

    public void updateShow(int id, Shows show){
        Optional<Shows> existing = getShowByID(id);
        showsRepository.save(show);
    }

    public void deleteShowById(int id){
        showsRepository.deleteById(id);
    }


}