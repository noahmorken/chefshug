package com.zono.chefshug.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.zono.chefshug.dao.RecipeDao;
import com.zono.chefshug.model.Ingredient;
import com.zono.chefshug.model.Recipe;
import com.zono.chefshug.model.Step;


import jakarta.websocket.server.PathParam;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao dao;

    @Autowired
    private RestTemplate restTemplate;

    public List<Recipe> listRecipes() {
        return dao.listRecipes();
    }
    
    public Recipe getRecipe(int id) {
        Recipe r = dao.getRecipe(id);
        if (StringUtils.isNotBlank(r.getUrl())) {
            UriComponents uri = UriComponentsBuilder.fromUriString(r.getUrl()).build();
            // We've got a URL to follow
            if ("localhost".equals(uri.getHost())) {
                // Load local resources
                BufferedReader reader = null;
                try {
                    File file = ResourceUtils.getFile("classpath:static" + uri.getPath());
                    InputStream is = new FileInputStream(file);
                    reader = new BufferedReader(new InputStreamReader(is));
                    String content = (String)reader.lines().collect(Collectors.joining(System.lineSeparator()));
                    r.setExternalContent(content);
                } catch (FileNotFoundException e) {
                    // Failar
                    e.printStackTrace();
                }
                finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (Exception ex) {
                            // don't care
                        }
                    }
                }
                return r;
            }
            
            ResponseEntity<String> re = restTemplate.getForEntity(r.getUrl(), String.class);
            if (re.getStatusCode().isError()) {
                // log.error(...)
            }
            else {
                r.setExternalContent(re.getBody());
            }
        }
        return r;
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
