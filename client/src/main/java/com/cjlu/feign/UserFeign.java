package com.cjlu.feign;

import com.cjlu.model.MenuPojo;
import com.cjlu.model.UserPojo;
import com.cjlu.util.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user")
public interface UserFeign {
    @GetMapping("user/findAll/{index}/{limit}")
    public ApiResult findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
    @DeleteMapping("user/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id);
    @GetMapping("user/findTypes")
    public ApiResult findTypes();
    @PostMapping("user/save")
    public Void save(UserPojo userPojo);
    @GetMapping("user/findById/{id}")
    public MenuPojo findById(@PathVariable("id") long id);
    @PutMapping("user/update")
    public void update(UserPojo userPojo);
}
