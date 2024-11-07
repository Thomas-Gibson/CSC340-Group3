package csc340.group3.ShowHunter.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/all")
    public List<Customer> getAllUsers()
    {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return service.getCustomerById(id);
    }

    @PostMapping("/new")
    public List<Customer> addUser(@RequestBody Customer user){
        service.addUser(user);
        return service.getAllUsers();
    }

    @DeleteMapping("/remove/{id}")
    public List<Customer> removeUser(@PathVariable int id)
    {
        service.removeUser(id);
        return service.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public List<Customer> updateUser(@RequestBody Customer user){
        service.updateUser(user);
        return service.getAllUsers();
    }
}
