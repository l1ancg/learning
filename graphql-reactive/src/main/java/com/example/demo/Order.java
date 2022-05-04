package com.example.demo;

import org.springframework.data.annotation.Id;

/**
 * Order
 *
 * @author L1an
 * @since 2022/5/3
 */
public record Order(@Id Integer id, Integer customerId) {
}
