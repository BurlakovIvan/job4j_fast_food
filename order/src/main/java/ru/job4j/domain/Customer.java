package ru.job4j.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String address;
    private String email;
}
