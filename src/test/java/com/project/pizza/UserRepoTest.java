package com.project.pizza;


import com.project.pizza.domain.aggregate.User;
import com.project.pizza.domain.entity.Address;
import com.project.pizza.domain.entity.Name;
import com.project.pizza.domain.entity.Password;
import com.project.pizza.domain.entity.Role;
import com.project.pizza.infrastracture.db.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepoTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private UserRepo userRepo;
        User user;

    @Test
    public void check_user_in_repo() {
        // given
        user = new User("email", new Name("bilal", "taghda")
                , Role.CHEF,new Address(0l, 0l), new Password("Password123") );
        entityManager.persist(user);
        entityManager.flush();

        // when
        User userFoundInRepo = userRepo.findByEmail(user.getEmail()).orElseThrow();

        // then
        Assertions.assertEquals(userFoundInRepo, user);
    }

}
