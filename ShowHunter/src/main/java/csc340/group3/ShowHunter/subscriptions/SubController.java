package csc340.group3.ShowHunter.subscriptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subs")
public class SubController {

    @Autowired
    private SubService service;

    @GetMapping("/all")
    public List<Sub> getAllSubs(){
        return service.getAllSubscriptions();
    }

    @GetMapping("/user/{id}")
    public List<Sub> getSubsByUser(@PathVariable int id){
        return service.getSubscriptionsByUser(id);
    }

    @GetMapping("/venue/{id}")
    public  List<Sub> getSubsByVenue(@PathVariable int id){
        return service.getSubscriptionsByVenue(id);
    }

    @PostMapping("/new")
    public List<Sub> addUser(@RequestBody Sub sub){
        service.addSubscription(sub);
        return service.getAllSubscriptions();
    }

    @DeleteMapping("/remove/{id}")
    public List<Sub> removeUser(@PathVariable int id)
    {
        service.removeSubscription(id);
        return service.getAllSubscriptions();
    }
}
