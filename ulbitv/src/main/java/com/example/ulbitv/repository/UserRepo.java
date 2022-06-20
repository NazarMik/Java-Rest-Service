package com.example.ulbitv.repository;

import com.example.ulbitv.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {

    public UserEntity findByUsername(String username);
}
