package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @PostMapping
    public void createTask() {
    }

    @GetMapping
    public void getTask() {
    }

    @GetMapping
    public void getAllTasks() {
    }

    @PatchMapping
    public void updateTask() {
    }

    @DeleteMapping
    public void deleteTask() {
    }
}
