package com.spring.springboot.controller;

import com.spring.springboot.entity.User;
import com.spring.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //Build Create Rest API


    //Rest WebService - Create USer API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user){
       User saveUser= userService.creatUser(user);
      return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    //Get UserById
    @GetMapping("{id}")
    public  ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
         User user=userService.getUserById(userId);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }


    //GetAll Users aPI
    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        List<User> users=userService.getAllUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Update User API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);
       User updatedUser= userService.updateUser(user);
       return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }


    /*
    @DeleteMapping("{id}")
    public  ResponseEntity<String>deleteUser (@PathVariable("id") Long userId){
       userService.deleteUser(userId);
       return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);

    }*/
}

