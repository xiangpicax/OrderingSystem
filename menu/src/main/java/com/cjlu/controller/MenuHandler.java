package com.cjlu.controller;

import com.cjlu.mapper.TypeMapper;
import com.cjlu.model.MenuPojo;
import com.cjlu.mapper.MenuMapper;
import com.cjlu.model.TypePojo;
import com.cjlu.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Value("${server.port}")
    String port;
    @GetMapping("/index")
    public String index(){
        return "端口号是："+port;
    }
    @GetMapping("/findAll/{index}/{limit}")
    public ApiResult findall(@PathVariable("index") int index, @PathVariable("limit") int limit){
        ApiResult<List<MenuPojo>> apiResult = new ApiResult();
        apiResult.setCount(menuMapper.count());
        return  apiResult.success(menuMapper.findAll(index,limit));
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuMapper.deleteById(id);
    }
    @GetMapping("/findTypes")
    public ApiResult findTypes(){
        ApiResult<List<TypePojo>> apiResult = new ApiResult<>();
        apiResult.setData(typeMapper.findAll());
        return apiResult;
    }
    @PostMapping("/save")
    public void save(@RequestBody  MenuPojo menuPojo){
        menuMapper.save(menuPojo);
    }
    @GetMapping("/findById/{id}")
    public MenuPojo findById(@PathVariable("id") long id){
       return menuMapper.findById(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody MenuPojo menuPojo){
        menuMapper.update(menuPojo);
    }
}
