package ru.job4j.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
    @Query("SELECT DISTINCT a FROM Status a LEFT JOIN FETCH a.order WHERE a.order.id = :id")
    Status findByOrderId(@Param("id") Integer orderId);
}
