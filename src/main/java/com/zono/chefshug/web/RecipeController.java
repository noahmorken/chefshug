package com.zono.chefshug.web;


import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zono.chefshug.model.Recipe;
import com.zono.chefshug.service.RecipeService;


@Controller
@RequestMapping(path = "/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/list")
    @ResponseBody
    public List<Recipe> listRecipes(Model model) {
        //model.addAttribute("hello", "world");
        //Map<String, String> map = new HashMap<>();
        //map.put("hello","world");
        return recipeService.listRecipes();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Recipe getRecipe(@PathVariable("id") int id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public void addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

}
