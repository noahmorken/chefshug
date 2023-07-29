package com.zono.chefshug.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zono.chefshug.model.User;

@Mapper
public interface UserDao {
    
    void registerUser(@Param("user") User user);
    void loginUser(@Param("user") User user);

}
