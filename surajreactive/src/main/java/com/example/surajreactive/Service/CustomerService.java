package com.example.surajreactive.Service;

import com.example.surajreactive.entity.Customer;
import com.example.surajreactive.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Flux<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Mono<Customer> saveCustomer(@NotNull Customer customer){
        customer.setCreatedBy("SSl");
        customer.setCreatedDate(new Date());
        return this.customerRepository.insert(customer);
    }
//    public  Mono<Customer> updateCustomer(String id,Customer customer)
//    {
//        return customerRepository.findById(id).flatMap(customerExist -> {
//            customerExist.setFirstName(customer.getFirstName());
//            customerExist.setMiddleName(customer.getMiddleName());
//            customerExist.setMiddleName(customer.getLastName());
//            customerExist.setUpdatedBy("SSlupdated");
//            customerExist.setUpdatedDate(new Date());
//            return customerRepository.save(customerExist);
//        });
//    }

    public  Mono<Customer> updateCustomer(String id,Customer customer){
        return customerRepository.findById(id)
                .flatMap(customerExist -> {
                    customerExist.setFirstName(customer.getFirstName());
                    customerExist.setMiddleName(customer.getMiddleName());
                    customerExist.setLastName(customer.getLastName());
                    customerExist.setUpdatedBy("SSlupdated");
                    customerExist.setUpdatedDate(new Date());
                    return customerRepository.save(customerExist);
                });
    }

    public  Flux<Customer> findByFirstName(String name)
    {
        return customerRepository.findByFirstName(name);
    }
    public Mono<Customer> deleteCustomer(String id)
    {
        return customerRepository.findById(id).flatMap(customerExist->{
            customerExist.setDeleted(true);
            return customerRepository.save(customerExist);
        });
    }



}
