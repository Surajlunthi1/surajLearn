package com.example.surajreactive.repository;

import com.example.surajreactive.entity.BaseMongo;
import com.example.surajreactive.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class CustomerRepositoryImp implements CustomerRepositoryCustom{

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;


    @Override
    public Flux<Customer> findGiven(String Name){
        final Query query = new Query();
        query.addCriteria(Criteria.where(BaseMongo.MIDDLE_NAME).is(Name)).limit(2);
        return reactiveMongoTemplate.find(query,Customer.class);
    }
}
