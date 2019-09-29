package com.cjlu.feign;

import com.cjlu.model.MenuPojo;
import com.cjlu.util.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("menu")
public interface MenuFeign {
    @GetMapping("menu/findAll/{index}/{limit}")
    public ApiResult findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
}
