package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Customer;
import ru.job4j.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> findById(int id) {
        return repository.findById(id);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
