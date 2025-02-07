package com.example.ejemploSecurity.controller;

import com.example.ejemploSecurity.model.Task;
import com.example.ejemploSecurity.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task/")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("{id}")
    public Task getById(@PathVariable("id") Long id){
        return taskService.getByID(id);
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(nuevo));
    }

}
