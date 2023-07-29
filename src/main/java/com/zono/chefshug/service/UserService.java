package com.zono.chefshug.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.zono.chefshug.dao.UserDao;
import com.zono.chefshug.model.User;

import jakarta.websocket.server.PathParam;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    public void registerUser(User user) {
        dao.registerUser(user);
    }

    @Transactional
    public void loginUser(User user) {
        dao.loginUser(user);
    }
}
