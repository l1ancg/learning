package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * CUstomerGraphqlController
 *
 * @author L1an
 * @since 2022/5/3
 */
@Controller
public class CustomerGraphqlController {

    private final CustomerReactiveRepository customerReactiveRepository;

    public CustomerGraphqlController(final CustomerReactiveRepository customerReactiveRepository) {
        this.customerReactiveRepository = customerReactiveRepository;
    }

    /**
     * 查询列表，graphql：
     * <pre>
     * {
     *   customers{
     *     id, name, __typename
     *   }
     * }
     * </pre>
     * 注解等同于：@SchemaMapping(typeName = "Query", field = "customers")
     */
    @QueryMapping
    Flux<Customer> customers() {
        return this.customerReactiveRepository.findAll();
    }

    /**
     * 关联查询，graphql：
     * <pre>
     * {
     *   customers{
     *     id, name, __typename, orders {id, customerId}
     *   }
     * }
     * </pre>
     * 注解固定写法，field可以省略使用方法名
     */
    @SchemaMapping(typeName = "Customer", field = "orders")
    Flux<Order> orders(final Customer customer) {
        final var result = new ArrayList<Order>();
        for (int orderId = 0; orderId < (Math.random() * 10); orderId++) {
            result.add(new Order(orderId, customer.id()));
        }
        return Flux.fromIterable(result);
    }

    /**
     * 条件查询，graphql：
     * <pre>
     * {
     *   customersByName(name: "Aa") {
     *     id, name, __typename, orders {id,customerId}
     *   }
     * }
     * </pre>
     * 注解等同于：@SchemaMapping(typeName = "Query", field = "customersByName")
     * 使用@QueryMapping，方法名等同于field
     */
    @QueryMapping
    Flux<Customer> customersByName(@Argument final String name) {
        return this.customerReactiveRepository.findByName(name);
    }

    /**
     * 插入数据，graphql：
     * <pre>
     * mutation {
     *   addCustomer(id: 5, name: "Ee") {
     *     id, name, orders { id, customerId }
     *   }
     * }
     * </pre>
     * <p>
     * 注解等同于：@SchemaMapping(typeName = "Mutation", field = "addCustomer")
     * 使用@QueryMapping，方法名等同于field
     */
    @MutationMapping
    Mono<Customer> addCustomer(@Argument final Integer id, @Argument final String name) {
        return this.customerReactiveRepository.save(new Customer(id, name));
    }

    /**
     * 模拟事件
     */
    @SubscriptionMapping
    Flux<CustomerEvent> customerEvents(@Argument final Integer customerId) {
        return this.customerReactiveRepository.findById(customerId)
                .flatMapMany(customer -> {
                    final var stream = Stream.generate(
                            () -> new CustomerEvent(customer, Math.random() > .5 ? CustomerEventType.DELETED : CustomerEventType.UPDATED));
                    return Flux.fromStream(stream);

                })
                .delayElements(Duration.ofSeconds(1))
                .take(5);
    }
}
