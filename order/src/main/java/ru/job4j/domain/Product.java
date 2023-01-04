package ru.job4j.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String description;
}
