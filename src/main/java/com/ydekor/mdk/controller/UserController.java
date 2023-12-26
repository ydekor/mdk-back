package com.ydekor.mdk.controller;

import com.ydekor.mdk.dto.UserDTO;
import com.ydekor.mdk.mapper.UserMapper;
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
    private final UserMapper userMapper;

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        userService.delete(id);
        return "record id " + id + " deleted success";
    }

    @PutMapping
    public UserDTO updateRecord(@RequestBody UserDTO userDTO) {
        return userMapper.sourceToDto(userService.update(userMapper.dtoToSource(userDTO)));
    }

    @PostMapping
    public UserDTO createRecord(@RequestBody UserDTO userDTO) {
        return userMapper.sourceToDto(userService.create(userMapper.dtoToSource(userDTO)));
    }

    @GetMapping // обработка get запросов
    public List<UserDTO> getAll() {
        return userMapper.sourcesToDtos(userService.getAll());
    }
}
