package org.hellofheaven.datademo.contoller;

import org.hellofheaven.datademo.model.Customer;
import org.hellofheaven.datademo.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    public Iterable<Customer> getAll(){
        return customerRepository.findAll();
    }

    @RequestMapping("/add")
    public HttpStatus addCustomer(){

        customerRepository.save(new Customer("Julia", "Huppi"));
        customerRepository.save(new Customer("Sarah", "Fluppi"));
        return HttpStatus.CREATED;
    }


}
