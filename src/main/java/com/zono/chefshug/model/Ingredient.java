package com.zono.chefshug.model;

import lombok.Data;

@Data
public class Ingredient {
    private Integer order;

    private String name;

    private Float quantity;

    private String uom;

}
