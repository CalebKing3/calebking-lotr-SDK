package com.lordofrings.sdk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieDocsDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private int total;
    private int limit;
    private int offset;
    private int page;
    private int pages;

}
