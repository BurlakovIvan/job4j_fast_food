package ru.job4j.food.model;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Kitchen {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
}
