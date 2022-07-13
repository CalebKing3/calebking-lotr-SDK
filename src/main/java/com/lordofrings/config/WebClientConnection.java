package com.lordofrings.config;

import com.lordofrings.constant.LotrConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConnection {

    @Bean
    public WebClient apiClient() {
        return WebClient.builder()
                .baseUrl(LotrConstants.API_URI)
                .defaultHeader("Authorization", LotrConstants.API_TOKEN)
                .build();
    }

}
