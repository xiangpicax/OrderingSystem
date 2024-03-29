package com.cjlu.feign;

import com.cjlu.model.MenuPojo;
import com.cjlu.util.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("menu")
public interface MenuFeign {
    @GetMapping("menu/findAll/{index}/{limit}")
    public ApiResult findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
    @DeleteMapping("menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id);
    @GetMapping("menu/findTypes")
    public ApiResult findTypes();
    @PostMapping("menu/save")
    public String save(MenuPojo menuPojo);
    @GetMapping("menu/findById/{id}")
    public MenuPojo findById(@PathVariable("id") long id);
    @PutMapping("menu/update")
    public void update(MenuPojo menuPojo);

}
