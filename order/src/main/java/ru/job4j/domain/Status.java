package ru.job4j.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "status")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String status;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
