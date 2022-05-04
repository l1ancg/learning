package com.example.demo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * CustomerReactiveRepository
 *
 * @author L1an
 * @since 2022/5/3
 */
public interface CustomerReactiveRepository extends ReactiveCrudRepository<Customer, Integer> {

    Flux<Customer> findByName(String name);
}