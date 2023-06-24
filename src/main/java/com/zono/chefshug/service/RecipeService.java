package com.zono.chefshug.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zono.chefshug.dao.RecipeDao;
import com.zono.chefshug.model.Recipe;

import jakarta.websocket.server.PathParam;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao dao;

    public List<Recipe> listRecipes() {
        // Map<String, String> map = new HashMap<>();
        // map.put("hello","world");
        // return map;
        return dao.listRecipes();
    }
    
    public Recipe getRecipe(int id) {
        return dao.getRecipe(id);
    }

}
