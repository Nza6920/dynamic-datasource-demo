package com.niu.datasource.controller;


import com.niu.datasource.entity.User;
import com.niu.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public Map<String, String> save() {
        User user = new User();
        user.setUserName("nza");
        user.setUserPhone("18708157016");
        user.setAddress("四川省成都市");
        user.setWeight(160);
        userService.save(user);
        HashMap<String, String> res = new HashMap<>();
        res.put("msg", "ok");
        return res;
    }
}
