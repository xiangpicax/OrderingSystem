package com.cjlu.mapper;

import com.cjlu.model.TypePojo;

import java.util.List;

public interface TypeMapper {
    public TypePojo findById(long id);
    public List<TypePojo> findAll();
}
