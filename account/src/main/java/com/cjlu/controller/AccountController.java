package com.cjlu.controller;

import com.cjlu.mapper.AdminMapper;
import com.cjlu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @Value("${server.port}")
    String port;

    @GetMapping("/index")
    public String getPort(){return "登入的端口号为:"+port; }

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Object object = null;
        switch (type){
            case "admin": object = adminMapper.login(username,password);
                break;
            case "user": object = userMapper.login(username,password);
                break;

        }
        return object;
    }
}
