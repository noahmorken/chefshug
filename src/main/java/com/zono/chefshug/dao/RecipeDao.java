package com.zono.chefshug.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zono.chefshug.model.Recipe;
import com.zono.chefshug.model.Ingredient;
import com.zono.chefshug.model.Step;

@Mapper
public interface RecipeDao {
    
    List<Recipe> listRecipes();
    Recipe getRecipe(int id);
    void addRecipe(@Param("recipe") Recipe recipe);
    void addIngredient(@Param("recipe") Recipe recipe, @Param("ingredient") Ingredient ingredient);
    void addStep(Recipe recipe, Step step);

}
