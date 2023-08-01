package com.zono.chefshug.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zono.chefshug.model.User;

@Mapper
public interface UserDao {
    
    void registerUser(@Param("user") User user);
    void loginUser(@Param("user") User user);
    User findById(Long id);
    Optional<User> findByUsername(String username);
    void save(User user);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
