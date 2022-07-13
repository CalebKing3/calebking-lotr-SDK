package com.lordofrings.controller;

import com.lordofrings.model.BookDTO;
import com.lordofrings.model.SearchMovieDTO;
import com.lordofrings.exception.BookNotFoundException;
import com.lordofrings.exception.MovieNotFoundException;
import com.lordofrings.model.Movie;
import com.lordofrings.model.MovieDTO;
import com.lordofrings.service.BookService;
import com.lordofrings.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SDKController {

    private static final Logger LOG = LoggerFactory.getLogger(SDKController.class);

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
    webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/v1/lord-of-the-rings");
    }

    @Autowired
    MovieService movieService;

    @Autowired
    BookService bookService;

    /**
     * @return all movies
     */
    @GetMapping("/movie")
    public ResponseEntity<MovieDTO> getAllMovies() {
        MovieDTO response = null;
        try {
            response = movieService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return all books
     */
    @GetMapping("/book")
    public ResponseEntity<BookDTO> getAllBooks() {
        BookDTO response = null;
        try {
            response = bookService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id
     * @return one movie by id
     */
    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable String id) {
        MovieDTO response = null;
        try {
            response = movieService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * @param id
     * @return one book by id
     */
    @GetMapping("/book/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable String id) {
        BookDTO response = null;
        try {
            response = bookService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BookNotFoundException e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * @return the longest movie by total runtime
     */
    @GetMapping("/movie/longest")
    public ResponseEntity<Movie> getLonestRuntimeMovie() {
        Movie movie = null;
        try {
            movie = movieService.getLongestRuntime();
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(movie, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return the book title name by searching by id
     */
    @GetMapping("/book/title/{id}")
    public ResponseEntity<String> getBookTitle(@PathVariable String id) {
        String response = null;
        try {
            response = bookService.getBookTitle(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return movies by search params
     */
    @PostMapping("/movie/search")
    public ResponseEntity<Movie> search(@RequestBody SearchMovieDTO searchMovieDTO) {
        Movie movie = null;
        try {
            movie = movieService.searchMovie(searchMovieDTO);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            LOG.error("Exception occured: " + e.getMessage());
            return new ResponseEntity<>(movie, HttpStatus.NOT_FOUND);
        }
    }

}
