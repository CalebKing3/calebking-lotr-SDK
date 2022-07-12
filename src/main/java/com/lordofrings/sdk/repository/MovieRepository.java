package com.lordofrings.sdk.repository;

import com.lordofrings.sdk.exception.MovieNotFoundException;
import com.lordofrings.sdk.model.Movie;
import com.lordofrings.sdk.model.MovieDTO;
import com.lordofrings.sdk.model.SearchMovieDTO;

/**
 * Repository to retrieve movie details about Lord of the Rings trilogy.
 */
public interface MovieRepository {

    MovieDTO getAll();

    MovieDTO getById(String id) throws MovieNotFoundException;

    Movie getLongestRuntime();

    Movie searchMovie(SearchMovieDTO searchMovieDTO);

}
