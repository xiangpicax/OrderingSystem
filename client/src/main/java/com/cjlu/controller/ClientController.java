package com.cjlu.controller;

import com.cjlu.feign.MenuFeign;
import com.cjlu.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private MenuFeign menuFeign;


    @GetMapping("/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }
}
