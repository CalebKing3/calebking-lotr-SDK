package com.lordofrings.repository;

import com.lordofrings.model.BookDTO;
import com.lordofrings.exception.BookNotFoundException;

/**
 * Repository to retrieve movie details about Lord of the Rings trilogy.
 */
public interface BookRepository {

    BookDTO getAll();

    BookDTO getById(String id) throws BookNotFoundException;

    String getBookTitle(String id) throws BookNotFoundException;

}
