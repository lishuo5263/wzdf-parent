package com.wzdf.userconsumer.service;

import com.wzdf.userconsumer.entity.User;
import com.wzdf.userconsumer.service.impl.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="user-provider",fallback = UserFallBack.class)
public interface UserFeignClient {

    @RequestMapping(value="/user/getUserById/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable int id);

    @RequestMapping(value="/user/saveUser",method = RequestMethod.POST)
    public User saveUser(@RequestBody User u);


}
