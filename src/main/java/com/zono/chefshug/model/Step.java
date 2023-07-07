package com.zono.chefshug.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Step {
    @JsonProperty("step_order")
    private Integer order;

    @JsonProperty("step")
    private String content;
}
