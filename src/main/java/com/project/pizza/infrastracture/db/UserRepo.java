package com.project.pizza.infrastracture.db;

import com.project.pizza.domain.aggregate.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, Long>{

    @Query("{ 'email' : ?0 }")
    Optional<User> findByEmail( String email);


}
