package com.wzdf.userprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;

    public static Map<Integer,User> map = new HashMap<>();

    static {
        map.put(1,new User("李白",15));
        map.put(2,new User("杜甫",12));
        map.put(3,new User("柳永",9));
    }

}
