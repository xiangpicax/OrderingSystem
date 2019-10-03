package com.cjlu.controller;

import com.cjlu.feign.MenuFeign;
import com.cjlu.model.MenuPojo;
import com.cjlu.model.TypePojo;
import com.cjlu.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuFeign menuFeign;


    @GetMapping("/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/index";
    }
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeign.findTypes().getData());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(MenuPojo menuPojo){
        menuFeign.save(menuPojo);
        return "redirect:/menu/redirect/index";
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        TypePojo typePojo = new TypePojo();
        modelAndView.addObject("list",menuFeign.findTypes().getData());
        return modelAndView;

    }
    @PostMapping("/update")
    public String update(MenuPojo menuPojo){
        menuFeign.update(menuPojo);
        return "redirect:/menu/redirect/index";
    }


}
