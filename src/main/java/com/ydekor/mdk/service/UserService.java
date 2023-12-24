package com.ydekor.mdk.service;

import com.ydekor.mdk.model.User;
import com.ydekor.mdk.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        if (user.getId() != null) {
            throw new RuntimeException("id is not allowed here");
        }
        return userRepository.save(user);
    }

    public User update(User user) {
        if (user.getId() == null) {
            throw new RuntimeException("id is required");
        }
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}