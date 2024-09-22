package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/8task/users")
public class UserController {

    private Map<Integer, User> userDatabase = new HashMap<>();
    private int currentId = 1;

    // Метод GET для получения информации о пользователе
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userDatabase.get(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Метод POST для создания нового пользователя
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        newUser.setId(currentId++);
        userDatabase.put(newUser.getId(), newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}