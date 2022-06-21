package com.example.ulbitv.controller;

import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.exception.UserAlreadyExists;
import com.example.ulbitv.exception.UserNotFoundException;
import com.example.ulbitv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("user is save");
        }catch (UserAlreadyExists e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getUserById(@RequestParam Long id){
        try {
           return ResponseEntity.ok(userService.getUserById(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
      try {
          return ResponseEntity.ok( userService.delete(id));
      }catch (Exception e){
          return ResponseEntity.badRequest().body("Error");
      }
    }
}
