package com.project.pizza.infrastracture.db;

import com.project.pizza.domain.aggregate.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends MongoRepository<Order, Long> {

    @Query("{ 'email' : ?0 }")
    Optional<List<Order>> findByEmail(String email);


}
