package com.cjlu.mapper;

import com.cjlu.model.AdminPojo;

import java.util.List;

public interface AdminMapper {
    public AdminPojo login(String username, String password);
}
