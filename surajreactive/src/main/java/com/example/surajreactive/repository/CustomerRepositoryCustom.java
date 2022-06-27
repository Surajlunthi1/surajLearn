package com.example.surajreactive.repository;

import com.example.surajreactive.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


public interface CustomerRepositoryCustom  {
        public Flux<Customer> findGiven(String name);

}
