package ru.job4j.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.domain.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.customer WHERE o.customer.id = :id")
    List<Order> findByCustomerId(@Param("id") Integer customerId);

    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.customer LEFT JOIN FETCH o.products")
    List<Order> findAll();
}
