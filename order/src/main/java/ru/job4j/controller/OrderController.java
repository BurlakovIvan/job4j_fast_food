package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.domain.Order;
import ru.job4j.domain.Status;
import ru.job4j.service.OrderService;
import ru.job4j.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final StatusService statusService;

    /**
     * Возвращает статус заказа
     * @param id идентификатор заказа
     * @return статус заказа
     */
    @GetMapping("/{id}")
    public ResponseEntity<Status> statusOrderById(@PathVariable int id) {
        validateId(id);
        orderService.findById(id).orElseThrow(this::notFound);
        return new ResponseEntity<>(statusService.findByOrderId(id), HttpStatus.OK);
    }

    /**
     * Получаем все заказы
     * @return список заказов
     */
    @GetMapping("/")
    public ResponseEntity<List<Order>> findAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Некорректный идентификатор");
        }
    }

    private ResponseStatusException notFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Заказ с таким идентификатором не найден"
        );
    }
}
