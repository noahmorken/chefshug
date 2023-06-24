package com.zono.chefshug.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class Recipe {
    private int id;

    private int variation;

    private Date date;

    private String name;

    private String intro;

    private Integer status;

    private List<Step> steps;

    private List<Ingredient> ingredients;
        
    private List<Comment> comments;
}
