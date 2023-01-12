package com.project.pizza.infrastracture.rdb;

import com.project.pizza.domain.aggregate.Order;
import com.project.pizza.domain.valueObject.OrderStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.email = :email")
    Optional<List<Order>> findUserOrdersByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE Order o SET o.status = :status WHERE o.id = :id")
    void updateOrderStatus(@Param("status") OrderStatus status, @Param("id") int id);
}
