package ru.job4j.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private LocalDateTime created;
    private User user;
    private Collection<Dish> dishes;
}
