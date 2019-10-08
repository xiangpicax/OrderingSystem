package com.cjlu.feign;

import com.cjlu.model.OrderPojo;
import com.cjlu.util.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("order")
public interface OrderFeign {
    @PostMapping("order/save")
    public void save(OrderPojo orderPojo);
    @GetMapping("order/findAllByUid/{index}/{limit}/{uid}")
    public ApiResult findByUid(@PathVariable("index") int index, @PathVariable("limit")int limit, @PathVariable("uid")long uid);
    @GetMapping("order/findAll/{index}/{limit}")
    public ApiResult findAll(@PathVariable("index") int index, @PathVariable("limit")int limit);
    @PutMapping("order/updateState/{id}")
    public void updateState(@PathVariable("id") long id);
}
