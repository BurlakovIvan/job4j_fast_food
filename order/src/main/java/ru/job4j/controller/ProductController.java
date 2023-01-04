package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.domain.Product;
import ru.job4j.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Получаем все данные
     * @return список продуктов
     */
    @GetMapping("/")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    /**
     * Ищем продукт по id
     * @param id идентификатор
     * @return продукт
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        validateId(id);
        return new ResponseEntity<>(productService.findById(id)
                .orElseThrow(this::notFound), HttpStatus.OK);
    }

    /**
     * Создаем продукт
     * @param product продукт
     * @return сохраненный в базу продукт
     */
    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    /**
     * Обновляем данные продукта
     * @param product продукт
     * @return статус обновления
     */
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Product product) {
        Product newProduct = productService.create(product);
        Optional<Product> findCustomer = productService.findById(newProduct.getId());
        if (findCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Не удалось обновить данные продукта"
            );
        }
        return ResponseEntity.ok().build();
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Некорректный идентификатор");
        }
    }

    private ResponseStatusException notFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Продукт с таким идентификатором не найден"
        );
    }





}
