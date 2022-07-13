package com.lordofrings.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("_id")
    private String id;
    private String name;
    private int total;
    private int limit;
    private int offset;
    private int page;
    private int pages;
}
