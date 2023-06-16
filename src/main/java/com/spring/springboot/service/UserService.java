package com.spring.springboot.service;

import com.spring.springboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User creatUser(User user);

   User getUserById(Long id);

   List<User> getAllUsers();

   User updateUser(User user);

   void  deleteUser(Long userId);
}
