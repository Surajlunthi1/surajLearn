package com.example.surajreactive.contollers;

import com.example.surajreactive.Service.CustomerService;
import com.example.surajreactive.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public Flux<Customer> getCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/customers/{name}")
    public Flux<Customer> findByMiddleName(@PathVariable String name) {
        return service.findByMiddleName(name);
    }

    @PostMapping("/customers")
    public Mono<Customer> saveCustomers(@RequestBody Customer customerMono){
        return service.saveCustomer(customerMono);
    }
    @PutMapping("/customers/{id}")
    public Mono<Customer> updateCustomer(@PathVariable String id,@RequestBody Customer customer)
    {
        return service.updateCustomer(id,customer);
    }
    @DeleteMapping("/customers/{id}")
    public Mono<Void> findById(@PathVariable String id){
        return service.deleteCustomer(id);
    }


}
