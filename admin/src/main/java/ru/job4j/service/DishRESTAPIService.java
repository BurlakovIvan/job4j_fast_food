package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Dish;
import ru.job4j.repository.DishRESTAPIRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DishRESTAPIService {

    private final DishRESTAPIRepository repository;

    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    public Dish findById(int id) {
        return repository.findById(id);
    }

    public Dish findByName(String name) {
        return repository.findByName(name);
    }

    public List<Dish> findAll() {
        return repository.findAll();
    }

    public Dish update(Dish dish) {
        return repository.update(dish);
    }

    public boolean delete(String id) {
        return repository.delete(id);
    }
}
