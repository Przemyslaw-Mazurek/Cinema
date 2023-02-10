package com.example.Cinema.controllers;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.User;
import com.example.Cinema.model.User;
import com.example.Cinema.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeUser(Long id) {
        userService.removeUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<User>> getUsersByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName){
        return ResponseEntity.ok(userService.getUsersByFirstNameAndLastName(firstName, lastName));
    }

    @GetMapping("findByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

}
