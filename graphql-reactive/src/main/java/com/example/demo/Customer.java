package com.example.demo;

import org.springframework.data.annotation.Id;

/**
 * Customer
 *
 * @author L1an
 * @since 2022/5/3
 */
public record Customer(@Id Integer id, String name) {
}
