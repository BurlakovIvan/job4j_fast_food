package ru.job4j.service;

import ru.job4j.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Dish save(Dish dish);

    Dish update(Dish dish);

    List<Dish> findAll();

    Optional<Dish> findDishById(int id);

    Optional<Dish> findDishByName(String name);

    boolean deleteDishById(int id);

}
