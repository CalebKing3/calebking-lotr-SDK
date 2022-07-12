package com.lordofrings.sdk.repository;

import com.lordofrings.sdk.exception.BookNotFoundException;
import com.lordofrings.sdk.model.BookDTO;

/**
 * Repository to retrieve movie details about Lord of the Rings trilogy.
 */
public interface BookRepository {

    BookDTO getAll();

    BookDTO getById(String id) throws BookNotFoundException;

    String getBookTitle(String id) throws BookNotFoundException;

}
