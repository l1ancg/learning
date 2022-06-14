package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    @RequestMapping("ctrl")
    public class Controller {
        @GetMapping("/test")
        public String test(DemoDTO dto) {
            return "receive -> " + dto.name();
        }
    }
}

record DemoDTO(String name, Integer age, String mobile, String nikeName) {
}


