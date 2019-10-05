package com.cjlu.controller;

import com.cjlu.feign.AccountFeign;
import com.cjlu.model.AdminPojo;
import com.cjlu.model.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountFeign accountFeign;
    @PostMapping("/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object =  accountFeign.login(username,password,type);
        LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap<String, Object>) object;
        String result = null;
        if(object == null){
           result = "login";
        }else{
            switch (type){
                case "user":
                    UserPojo userPojo = new UserPojo();
                    userPojo.setId(Long.parseLong(linkedHashMap.get("id")+""));
                    userPojo.setNickname((String)linkedHashMap.get("nickname"));
                    session.setAttribute("user",userPojo);
                    result = "index";
                    break;
                case"admin":
                    AdminPojo adminPojo = new AdminPojo();
                    adminPojo.setId(Long.parseLong(linkedHashMap.get("id")+""));
                    adminPojo.setUsername((String)linkedHashMap.get("username"));
                    session.setAttribute("admin",adminPojo);
                    result = "menu_manage";
                    break;
            }
        }
     return result;

    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
