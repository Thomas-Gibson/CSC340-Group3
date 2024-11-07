package csc340.group3.ShowHunter.provider.shows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowsService {

    @Autowired
    private csc340.group3.ShowHunter.provider.shows.ShowsRepository showsRepository;

    public List<Shows> getAllShows() {
        return showsRepository.findAll();
    }

    public Optional<Shows> getShowByID(int id) {
        return showsRepository.findById(id);
    }

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