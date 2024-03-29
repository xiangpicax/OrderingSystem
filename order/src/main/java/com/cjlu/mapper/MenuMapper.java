package com.cjlu.mapper;

import com.cjlu.model.MenuPojo;

import java.util.List;

public interface MenuMapper {
    public List<MenuPojo> findAll(int index, int limit);
    public long count();
    public void save(MenuPojo menu);
    public MenuPojo findById(long id);
    public void update(MenuPojo menu);
    public void deleteById(long id);



}
