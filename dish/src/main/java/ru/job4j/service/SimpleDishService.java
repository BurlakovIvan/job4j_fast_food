package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Dish;
import ru.job4j.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private final DishRepository repository;

    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Dish> findDishById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Dish> findDishByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public boolean deleteDishById(int id) {
        return repository.deleteById(id);
    }

}
