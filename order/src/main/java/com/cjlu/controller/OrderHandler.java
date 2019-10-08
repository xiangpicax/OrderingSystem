package com.cjlu.controller;

import com.cjlu.mapper.OrderMapper;
import com.cjlu.model.OrderPojo;
import com.cjlu.util.ApiResult;
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

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public ApiResult findAllByUid(@PathVariable("index") int index, @PathVariable("limit")int limit,@PathVariable("uid")long uid){
        ApiResult<List<OrderPojo>> apiResult = new ApiResult();
        apiResult.setCount(orderMapper.countByUid(uid));
        apiResult.success(orderMapper.findAllByUid(index,limit,uid));
        return apiResult;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public ApiResult findAll(@PathVariable("index") int index, @PathVariable("limit")int limit){
        ApiResult<List<OrderPojo>> apiResult = new ApiResult();
        apiResult.setCount(orderMapper.count());
        apiResult.success(orderMapper.findAll(index,limit));
        return apiResult;
    }
    @PutMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") long id){
        orderMapper.updateState(id);
    }
}
