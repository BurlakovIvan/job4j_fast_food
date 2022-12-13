package ru.job4j.food.service;

import ru.job4j.food.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    /**
     * добавляем новое блюдо
     * @param dish блюдо, которое добавляем
     */
    void add(Dish dish);

    /**
     * Все блюда которые у нас есть
     * @return список
     */
    List<Dish> findAll();

    /**
     * получаем наше блюдо по его идентификатору
     * @param id идентификатор блюда
     * @return найденное блюдо
     */
    Optional<Dish> findById(int id);

    /**
     * Ищем блюдо по названию
     * @param dishName название блюда
     * @return найденное блюдо
     */
    Optional<Dish> findByName(String dishName);

    /**
     * удаляем блюдо по названию
     * @param dishName - название блюда
     */
    void deleteByName(String dishName);

    /**
     * обновляем наше блюдо, например описание
     * @param dish блюда которое необходимо обновить
     */
    void update(Dish dish);

}
