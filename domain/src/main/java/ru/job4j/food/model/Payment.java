package ru.job4j.food.model;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private Order order;
    private User user;
}
