package com.example.ulbitv.service;

import com.example.ulbitv.entity.ToDoEntity;
import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.model.Todo;
import com.example.ulbitv.repository.TodoRepo;
import com.example.ulbitv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(ToDoEntity todo, Long id){
        UserEntity user = userRepo.findById(id).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id){
    ToDoEntity todo = todoRepo.findById(id).get();
    todo.setComplete(!todo.getComplete());
        return Todo.toModel(todoRepo.save(todo));
    }
}
