package com.ydekor.mdk.controller;

import com.ydekor.mdk.model.User;
import com.ydekor.mdk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        userService.delete(id);
        return "record id " + id + " deleted success";
    }

    @PutMapping
    public User updateRecord(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping
    public User createRecord(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping // обработка get запросов
    public List<User> getAll() {
        return userService.getAll();
    }
}
