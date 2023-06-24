package com.zono.chefshug.model;

import java.sql.Blob;
import java.sql.Date;

import lombok.Data;

@Data
public class Comment {
    private Integer id;

    private Integer rec;

    private Integer var;

    private String user;

    private Date date;

    private Blob content;
}
