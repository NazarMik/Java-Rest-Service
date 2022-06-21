package com.example.ulbitv.controller;

import com.example.ulbitv.entity.ToDoEntity;
import com.example.ulbitv.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity toDo,
                                     @RequestParam Long userId){
        try {
        return ResponseEntity.ok(todoService.createTodo(toDo,userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping
    public ResponseEntity completed(@RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.complete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
