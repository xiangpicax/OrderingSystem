package com.cjlu.controller;

import com.cjlu.mapper.UserMapper;
import com.cjlu.model.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    public List<UserPojo> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return userMapper.findAll(index,limit);
    }
    @GetMapping("/count")
    public long count(){
        return userMapper.count();
    }
    @PostMapping("/save")
    public void save(@RequestBody UserPojo user){
        userMapper.save(user);
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
