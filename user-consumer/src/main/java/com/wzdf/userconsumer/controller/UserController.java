package com.wzdf.userconsumer.controller;

import com.wzdf.userconsumer.entity.User;
import com.wzdf.userconsumer.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("userC")
public class UserController {

    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/getUserByIdC/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userFeignClient.getUserById(id);
        return user;
    }

    @PostMapping("/saveUserC")
    public User saveUser(@RequestBody User u){
        if(Optional.ofNullable(u).isPresent()){
            System.out.println(u);
        }
        u.setAge(25);
        User user =userFeignClient.saveUser(u);
        return  user;
    }
}
