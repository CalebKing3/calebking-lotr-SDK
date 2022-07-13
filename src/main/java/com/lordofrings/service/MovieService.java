package com.lordofrings.service;

import com.lordofrings.model.SearchMovieDTO;
import com.lordofrings.repository.MovieRepository;
import com.lordofrings.config.WebClientConnection;
import com.lordofrings.exception.MovieNotFoundException;
import com.lordofrings.model.Movie;
import com.lordofrings.model.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements MovieRepository {

    @Autowired
    WebClientConnection webClient;

    @Override
    public MovieDTO getAll() {
        Mono<MovieDTO> getResponse = webClient.apiClient()
                .get().uri("/movie")
                .retrieve().bodyToMono(MovieDTO.class);
        return getResponse.block();
    }

    @Override
    public MovieDTO getById(String id) {
        MovieDTO getResponse = webClient.apiClient()
                .get().uri("/movie/" + id)
                .retrieve()
                .bodyToFlux(MovieDTO.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Flux.empty()
                                : Mono.error(new MovieNotFoundException("Movie not found"))).blockFirst();

        return getResponse;
    }

    @Override
    public Movie getLongestRuntime() {

        Comparator<Movie> comparator = Comparator.comparing(Movie::getRuntimeInMinutes);
        return getAll().getMovies().stream().max(comparator).get();
    }


    @Override
    public Movie searchMovie(SearchMovieDTO searchMovieDTO) {

        List<Movie> movie = getAll().getMovies().stream()
                .filter(m -> m.getName().equals(searchMovieDTO.getName()))
                .collect(Collectors.toList());

        if (movie.isEmpty()) {
            throw new MovieNotFoundException("Movie not found");
        }
        return movie.get(0);

    }
}
