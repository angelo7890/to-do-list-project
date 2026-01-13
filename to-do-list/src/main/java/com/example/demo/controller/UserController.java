package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping
    public void createUser() {
    }

    @GetMapping
    public void getUser() {
    }

    @GetMapping
    public void getAllUsers() {
    }

    @PatchMapping
    public void updateUser() {
    }

    @DeleteMapping
    public void deleteUser() {
    }
}
