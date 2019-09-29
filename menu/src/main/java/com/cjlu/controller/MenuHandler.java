package com.cjlu.controller;

import com.cjlu.model.MenuPojo;
import com.cjlu.service.MenuService;
import com.cjlu.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuService menuService;

    @Value("${server.port}")
    String port;
    @GetMapping("/index")
    public String index(){
        return "端口号是："+port;
    }
    @GetMapping("/findAll/{index}/{limit}")
    public ApiResult findall(@PathVariable("index") int index, @PathVariable("limit") int limit){
        ApiResult<List<MenuPojo>> apiResult = new ApiResult();
        apiResult.setCount(menuService.count());
        return  apiResult.success(menuService.findAll(index,limit));

    }
}
