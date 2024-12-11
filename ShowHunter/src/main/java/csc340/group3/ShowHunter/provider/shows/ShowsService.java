package csc340.group3.ShowHunter.provider.shows;

import csc340.group3.ShowHunter.provider.venues.Venue;
import csc340.group3.ShowHunter.provider.venues.VenueRepository;
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

    public List<Shows> getShowsByVenueID(int id) {
        return showsRepository.findByVenueId(id);
    }

    public Optional<Shows> getShowByID(int id) {
        return showsRepository.findById(id);
    }

    public void addShow(Shows show){
        showsRepository.save(show);
    }


    public void updateShow(int id, Shows show){
        Shows existing = getShowByID(id).orElse(null);
        showsRepository.save(show);
    }

    public void deleteShowById(int id){
        showsRepository.deleteById(id);
    }


}