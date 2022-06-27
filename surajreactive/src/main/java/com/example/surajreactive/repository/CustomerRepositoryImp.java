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
    public Flux<Customer> findByFirstName(String Name){
        final Query query = new Query();
        query.addCriteria(Criteria.where(BaseMongo.FIRST_NAME).is(Name)).limit(2);
        return reactiveMongoTemplate.find(query,Customer.class);
    }

    @Override
    public Flux<Customer> findAll()
    {
        final Query query = new Query();
        query.addCriteria(Criteria.where(BaseMongo.IS_DELETED).is(null));
        return reactiveMongoTemplate.find(query,Customer.class);
    }

}
