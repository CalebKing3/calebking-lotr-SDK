package com.lordofrings.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonPropertyOrder({"docs"})
public class BookDTO extends Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("docs")
    private List<Book> books;

}
