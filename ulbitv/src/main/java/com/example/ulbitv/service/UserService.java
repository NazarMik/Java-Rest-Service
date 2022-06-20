package com.example.ulbitv.service;

import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.exception.UserAlreadyExists;
import com.example.ulbitv.exception.UserNotFoundException;
import com.example.ulbitv.model.User;
import com.example.ulbitv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExists {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExists("takiy ye");
        }
           return userRepo.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if ( user == null){
        throw new UserNotFoundException("takogo nema");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
