package csc340.group3.ShowHunter.provider.shows;

import csc340.group3.ShowHunter.provider.shows.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shows")
public class ShowsController {

    @Autowired
    private ShowsService showsService;

    @GetMapping("/all")
    public List<Shows> getAllShows() {
        return showsService.getAllShows();
    }

    @GetMapping("/{id}")
    public Optional<Shows> getOneShow(@PathVariable int id) {
        return showsService.getShowByID(id);
    }

    @PostMapping("/{id}/new")
    public List<Shows> addShow(@RequestBody Shows show) {
        showsService.addShow(show);
        return showsService.getAllShows();
    }

    @PutMapping("/update/{id}")
    public Optional<Shows> updateShow(@PathVariable int id, @RequestBody Shows show) {
        showsService.updateShow(id, show);
        return showsService.getShowByID(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Shows> deleteShowById(@PathVariable int id) {
        showsService.deleteShowById(id);
        return showsService.getAllShows();
    }

}
