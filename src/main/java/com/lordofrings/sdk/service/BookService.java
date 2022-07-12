package com.lordofrings.sdk.service;

import com.lordofrings.sdk.config.WebClientConnection;
import com.lordofrings.sdk.exception.BookNotFoundException;
import com.lordofrings.sdk.model.BookDTO;
import com.lordofrings.sdk.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService implements BookRepository {

    @Autowired
    WebClientConnection webClient;

    @Override
    public BookDTO getAll() {
        Mono<BookDTO> getResponse = webClient.apiClient()
                .get().uri("/book")
                .retrieve().bodyToMono(BookDTO.class);
        return getResponse.block();
    }

    @Override
    public BookDTO getById(String id) {
        BookDTO getResponse = webClient.apiClient()
                .get().uri("/book/" + id)
                .retrieve()
                .bodyToFlux(BookDTO.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Flux.empty()
                                : Mono.error(new BookNotFoundException("Book not found"))).blockFirst();

        return getResponse;
    }

    @Override
    public String getBookTitle(String id) {
        BookDTO getResponse = webClient.apiClient()
                .get().uri("/book/" + id)
                .retrieve()
                .bodyToFlux(BookDTO.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Flux.empty()
                                : Mono.error(new BookNotFoundException("Book not found"))).blockFirst();

        return getResponse.getName();
    }
}
