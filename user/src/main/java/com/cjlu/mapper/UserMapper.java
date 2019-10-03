package com.cjlu.mapper;

import com.cjlu.model.UserPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    public List<UserPojo> findAll(int index, int limit);
    public long count();
    public void save(UserPojo user);
    public UserPojo findById(long id);
    public void update(UserPojo user);
    public void deleteById(long id);

}
