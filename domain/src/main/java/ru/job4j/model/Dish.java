package ru.job4j.model;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String description;
}
