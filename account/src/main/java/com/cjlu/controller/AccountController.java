package com.cjlu.controller;

import com.cjlu.model.AdminPojo;
import com.cjlu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AdminService adminService;

    @Value("${server.port}")
    String port;

    @GetMapping("/index")
    public String getPort(){return "登入的端口号为:"+port; }

    @GetMapping("/login/{username}/{password}")
    public AdminPojo getAdmin(@PathVariable("username") String username,@PathVariable("password") String password){
        return adminService.login(username,password);
    }
}
