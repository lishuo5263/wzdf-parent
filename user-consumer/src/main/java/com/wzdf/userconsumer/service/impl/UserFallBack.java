package com.wzdf.userconsumer.service.impl;

import com.wzdf.userconsumer.entity.User;
import com.wzdf.userconsumer.service.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFallBack implements UserFeignClient {
    @Override
    public User saveUser(User u) {
        return new User("failure",25);
    }

    @Override
    public User getUserById(int id) {
        return new User("lee",0);
    }
}
