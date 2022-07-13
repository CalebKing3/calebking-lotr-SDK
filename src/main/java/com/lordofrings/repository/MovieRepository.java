package com.lordofrings.repository;

import com.lordofrings.model.SearchMovieDTO;
import com.lordofrings.exception.MovieNotFoundException;
import com.lordofrings.model.Movie;
import com.lordofrings.model.MovieDTO;

/**
 * Repository to retrieve movie details about Lord of the Rings trilogy.
 */
public interface MovieRepository {

    MovieDTO getAll();

    MovieDTO getById(String id) throws MovieNotFoundException;

    Movie getLongestRuntime();

    Movie searchMovie(SearchMovieDTO searchMovieDTO);

}
