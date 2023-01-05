package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.model.Dish;
import ru.job4j.service.DishService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/dish")
public class DishController {

    private final DishService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Dish>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<Dish> findById(@RequestParam int id) {
        validateId(id);
        return new ResponseEntity<>(service.findDishById(id)
                .orElseThrow(this::notFound), HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<Dish> findByName(@RequestParam String name) {
        return new ResponseEntity<>(service.findDishByName(name)
                .orElseThrow(this::notFound), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        return new ResponseEntity<>(service.save(dish), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Dish> update(@RequestBody Dish dish) {
        return new ResponseEntity<>(service.update(dish), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam int id) {
        return new ResponseEntity<>(service.deleteDishById(id), HttpStatus.OK);
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Некорректный идентификатор");
        }
    }

    private ResponseStatusException notFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Блюдо не найдено"
        );
    }
}
