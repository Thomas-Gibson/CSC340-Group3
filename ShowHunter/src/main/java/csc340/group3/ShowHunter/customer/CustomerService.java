package csc340.group3.ShowHunter.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> getAllUsers() {
        return repo.findAll();
    }

    public Customer getCustomerById(int id){
        return repo.findById(id).get();
    }

    public void addUser(Customer user){
        repo.save(user);
    }

    public void removeUser(int id){
        repo.deleteById(id);
    }

    public void updateUser(Customer user){
        repo.save(user);
    }

}
