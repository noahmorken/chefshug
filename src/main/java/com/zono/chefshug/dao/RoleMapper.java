package com.zono.chefshug.dao;

import java.util.Optional;

import com.zono.chefshug.model.Role;
import com.zono.chefshug.model.ERole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    Optional<Role> findById(Integer id);
    Optional<Role> findByName(ERole name);

    // Add other queries as needed
}
