package com.wzdf.userprovider.controller;

import com.wzdf.userprovider.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        System.out.println(1111);
        User user = User.map.get(id);
        return user;
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User u){
        System.out.println(222222);
        if(Optional.ofNullable(u).isPresent()){
            if(u.getAge()==25){
                u.map.put(4,new User("ls",25));
            }else{
                System.out.println("do nothing");
            }
        }
        return User.map.get(4);
    }
}
