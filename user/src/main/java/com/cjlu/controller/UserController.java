package com.cjlu.controller;

import com.cjlu.mapper.UserMapper;
import com.cjlu.model.UserPojo;
import com.cjlu.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    String port;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/index")
    public String index(){
       return "端口号是："+this.port;
    }
    @GetMapping("/findAll/{index}/{limit}")
    public ApiResult findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        ApiResult<List<UserPojo>> apiResult = new ApiResult<>();
        apiResult.setCount(userMapper.count());
        return apiResult.success(userMapper.findAll(index,limit));
    }
    @GetMapping("/count")
    public long count(){
        return userMapper.count();
    }
    @PostMapping("/save")
    public void save(@RequestBody UserPojo userPojo){
        userPojo.setRegisterDate(new Date());
        userMapper.save(userPojo);
    }
    @GetMapping("/findById/{id}")
    public UserPojo findById(@PathVariable("id")long id){
        return userMapper.findById(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody UserPojo user){
        userMapper.update(user);
    }
    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userMapper.deleteById(id);
    }
}
