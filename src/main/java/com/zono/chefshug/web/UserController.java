package com.zono.chefshug.web;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zono.chefshug.model.User;
import com.zono.chefshug.service.UserService;


@Controller
@CrossOrigin
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ResponseBody
    public void loginUser(@PathVariable User user) {
        userService.loginUser(user);
    }

    @PostMapping("/register")
    @ResponseBody
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }
    
}
