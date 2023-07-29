package com.zono.chefshug.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Ingredient {
    @JsonProperty("ingredient_order")
    private Integer order;

    @JsonProperty("ingredient")
    private String name;

    @JsonProperty("ingredient_quantity")
    private String quantity;

    @JsonProperty("ingredient_uom")
    private String uom;

}
