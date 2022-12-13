package ru.job4j.food.model;

import lombok.*;

import java.util.Collection;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private Collection<Order> orders;
}
