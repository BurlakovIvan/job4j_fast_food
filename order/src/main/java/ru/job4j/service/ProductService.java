package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Product;
import ru.job4j.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(Product product) {
        return repository.save(product);
    }

    public Set<Product> findProductById(List<Integer> id) {
        return repository.findProductById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(int id) {
        return repository.findById(id);
    }

}
