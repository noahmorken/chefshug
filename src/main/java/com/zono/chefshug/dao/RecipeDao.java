package com.zono.chefshug.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zono.chefshug.model.Recipe;

@Mapper
public interface RecipeDao {
    
    List<Recipe> listRecipes();
    Recipe getRecipe(int id);

}
