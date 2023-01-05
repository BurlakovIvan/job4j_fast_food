package ru.job4j.repository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.model.Dish;

import java.util.Collections;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
@AllArgsConstructor
public class DishRESTAPIRepository {

    @Value("${dish-api-url}")
    private String url;

    private final RestTemplate client;

    public Dish save(Dish dish) {
        return client.postForEntity(
                url, dish, Dish.class
        ).getBody();
    }

    public Dish findById(int id) {
        return client.getForEntity(
                String.format("%s/getById?id=%s", url, id),
                Dish.class
        ).getBody();
    }

    public Dish findByName(String name) {
        return client.getForEntity(
                String.format("%s/getByName?name=%s", url, name),
                Dish.class
        ).getBody();
    }

    public List<Dish> findAll() {
        List<Dish> body = client.exchange(
                String.format("%s/getAll", url), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }

    public Dish update(Dish dish) {
        return client.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Dish.class
        ).getBody();
    }

    public boolean delete(String id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }
}
