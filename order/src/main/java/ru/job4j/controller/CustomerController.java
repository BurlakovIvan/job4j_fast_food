package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.domain.Customer;
import ru.job4j.domain.Order;
import ru.job4j.service.CustomerService;
import ru.job4j.service.OrderService;
import ru.job4j.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;

    /**
     * Получаем всех покупателей
     * @return список покупателей
     */
    @GetMapping("/")
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    /**
     * Ищем покупателя по id
     * @param id идентификатор покупателя
     * @return покупатель
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable int id) {
        validateId(id);
        return new ResponseEntity<>(customerService.findById(id)
                .orElseThrow(this::notFound), HttpStatus.OK);
    }

    /**
     * Возвращаем все заказы покупателя
     * @param id идентификатор покупателя
     * @return список заказов покупателя
     */
    @GetMapping("/orderAll/{id}")
    public ResponseEntity<List<Order>> findOrderByCustomer(@PathVariable int id) {
        validateId(id);
        customerService.findById(id).orElseThrow(this::notFound);
        return new ResponseEntity<>(orderService.findOrderByCustomer(id), HttpStatus.OK);
    }

    /**
     * Новый заказ покупателя
     * @param order сам заказ
     * @param id идентификатор покупателя
     * @param productsId выбранные продукты в заказе
     * @return сохраненный заказ
     */
    @PostMapping("/customer/order/{id}")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, @PathVariable int id,
                                             @RequestParam(name = "productsId", required = false)
                                             List<Integer> productsId) {
        order.setCustomer(customerService.findById(id)
                .orElseThrow(this::notFound));
        order.setProducts(productService.findProductById(productsId));
        Order newOrder = orderService.create(order);
        Optional<Order> findOrder = orderService.findById(newOrder.getId());
        if (findOrder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Не удалось создать заказ"
            );
        }
        return new ResponseEntity<>(orderService.create(order), HttpStatus.CREATED);
    }

    /**
     * Создаем покупателя
     * @param customer покупатель
     * @return сохраненный в базу покупатель
     */
    @PostMapping("/")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
    }

    /**
     * Обновляем данные покупателя
     * @param customer покупатель
     * @return статус обновления
     */
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Customer customer) {
        Customer newCustomer = customerService.create(customer);
        Optional<Customer> findCustomer = customerService.findById(newCustomer.getId());
        if (findCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Не удалось обновить данные покупателя"
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
                "Пользователь с таким идентификатором не найден"
        );
    }
}
