package com.example.ulbitv.model;


import com.example.ulbitv.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity){
        User user = new User();
        user.setUsername(entity.getUsername());
        user.setId(entity.getId());
        user.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return user;
    }

    public User() {
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
