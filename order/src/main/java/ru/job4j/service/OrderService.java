package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Order;
import ru.job4j.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Order create(Order order) {
        return repository.save(order);
    }

    public List<Order> findOrderByCustomer(int customerId) {
        return repository.findByCustomerId(customerId);
    }

    public Optional<Order> findById(int id) {
        return repository.findById(id);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
}
