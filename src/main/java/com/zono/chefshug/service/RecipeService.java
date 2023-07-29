package com.zono.chefshug.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.zono.chefshug.dao.RecipeDao;
import com.zono.chefshug.model.Ingredient;
import com.zono.chefshug.model.Recipe;
import com.zono.chefshug.model.Step;

import jakarta.websocket.server.PathParam;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao dao;

    public List<Recipe> listRecipes() {
        // Map<String, String> map = new HaashMap<>();
        // map.put("hello","world");
        // return map;
        return dao.listRecipes();
    }
    
    public Recipe getRecipe(int id) {
        return dao.getRecipe(id);
    }

    @Transactional
    public void addRecipe(Recipe recipe) {
        if ("".equals(recipe.getUrl())) {
            recipe.setUrl(null);
        }
        dao.addRecipe(recipe);
        for(Ingredient ingredient: recipe.getIngredients()) {
            dao.addIngredient(recipe, ingredient);
        }
        for(Step step: recipe.getSteps()) {
            dao.addStep(recipe, step);
        }
    }

    @Transactional
    public void updateRecipe(Recipe recipe) {
        dao.deleteIngredient(recipe.getId());
        dao.deleteStep(recipe.getId());
        dao.updateRecipe(recipe);
        for(Ingredient ingredient: recipe.getIngredients()) {
            dao.addIngredient(recipe, ingredient);
        }
        for(Step step: recipe.getSteps()) {
            dao.addStep(recipe, step);
        }
    }

    @Transactional
    public void deleteRecipe(Integer recipeId) {
        dao.deleteRecipe(recipeId);
    }
}
