package com.cjlu.controller;

import com.cjlu.feign.MenuFeign;
import com.cjlu.feign.UserFeign;
import com.cjlu.model.MenuPojo;
import com.cjlu.model.TypePojo;
import com.cjlu.model.UserPojo;
import com.cjlu.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserFeign userFeign;


    @GetMapping("/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return userFeign.findAll(index,limit);
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_add");
        modelAndView.addObject("list",userFeign.findTypes().getData());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(UserPojo userPojo){
        userFeign.save(userPojo);
        return "redirect:/user/redirect/user_manage";
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",userFeign.findById(id));
        modelAndView.addObject("list",userFeign.findTypes().getData());
        return modelAndView;

    }


}
