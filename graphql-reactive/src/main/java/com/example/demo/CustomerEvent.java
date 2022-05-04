package com.example.demo;

/**
 * CustomerEvent
 *
 * @author L1an
 * @since 2022/5/3
 */
public record CustomerEvent(Customer customer, CustomerEventType event) {
}

enum CustomerEventType {
    UPDATED,
    DELETED
}
