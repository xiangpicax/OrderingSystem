package com.cjlu.controller;

import com.cjlu.mapper.OrderMapper;
import com.cjlu.model.OrderPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    String port;
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/index")
    public String index(){
        return "端口号是："+this.port;
    }

    @PostMapping("/save")
    public void save(@RequestBody OrderPojo orderPojo){
        orderPojo.setDate(new Date());
        orderMapper.save(orderPojo);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<OrderPojo> findAll(@PathVariable("index") int index, @PathVariable("limit")int limit){
        return orderMapper.findAll(index,limit);
    }
}
