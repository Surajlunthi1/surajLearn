package com.example.surajreactive.repository;

import com.example.surajreactive.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> ,CustomerRepositoryCustom{


}
