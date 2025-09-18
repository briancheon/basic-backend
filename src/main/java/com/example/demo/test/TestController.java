package com.example.demo.test;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/posts")
    public String test() {
        return "test";
    }

    @PostMapping("/test")
    public String post() {
        return "post";
    }

    @DeleteMapping("/test/{id}")
    public String delete() {
        return "delete";
    }
}
