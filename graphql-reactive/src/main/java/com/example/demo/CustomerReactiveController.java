package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CustomerReactiveController
 *
 * @author L1an
 * @since 2022/5/3
 */
@RestController
public class CustomerReactiveController {

    private final CustomerReactiveRepository customerReactiveRepository;

    CustomerReactiveController(final CustomerReactiveRepository customerReactiveRepository) {
        this.customerReactiveRepository = customerReactiveRepository;
    }


    @PostMapping("/create")
    public Mono<Customer> create(@RequestBody final Customer customer) {
        return this.customerReactiveRepository.save(customer);
    }

    @PostMapping("/update")
    public Mono<Customer> update(@RequestBody final Customer customer) {
        return this.customerReactiveRepository.save(customer);
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> get(@PathVariable("id") final Integer id) {
        return this.customerReactiveRepository.findById(id);
    }

    @GetMapping("/customers")
    public Flux<Customer> getAll() {
        return this.customerReactiveRepository.findAll();
    }

    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        this.customerReactiveRepository.deleteById(id);
    }

}
