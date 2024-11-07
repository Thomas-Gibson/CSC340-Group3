package csc340.group3.ShowHunter.subscriptions;

import csc340.group3.ShowHunter.customer.Customer;
import jdk.jshell.JShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubService {

    @Autowired
    private SubRepository repo;

    public List<Sub> getAllSubscriptions()
    {
        return repo.findAll();
    }

    public void addSubscription(Sub subscription){
        repo.save(subscription);
    }

    public void removeSubscription(int id){
        repo.deleteById(id);
    }

    public List<Sub> getSubscriptionsByUser(int id) {
        return repo.getSubSubscriptionsByUser(id);
    }

    public List<Sub> getSubscriptionsByVenue(int id) {
        return repo.getSubSubscriptionsByVenue(id);
    }
}
