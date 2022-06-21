package com.example.ulbitv.repository;

import com.example.ulbitv.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<ToDoEntity, Long> {

}
