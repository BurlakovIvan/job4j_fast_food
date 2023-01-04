package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Status;
import ru.job4j.repository.StatusRepository;

@Service
@AllArgsConstructor
public class StatusService {

    private final StatusRepository repository;

    public void create(Status status) {
        repository.save(status);
    }

    public Status findByOrderId(int orderId) {
        return repository.findByOrderId(orderId);
    }
}
