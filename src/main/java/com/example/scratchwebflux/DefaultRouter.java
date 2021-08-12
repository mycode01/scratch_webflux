package com.example.scratchwebflux;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class DefaultRouter {

  @Bean
  public RouterFunction<ServerResponse> personRoute(DefaultHandler handler) {
    return
        route(GET("/person/{id}").and(accept(APPLICATION_JSON)), handler::getPerson)
            .andRoute(GET("/person").and(accept(APPLICATION_JSON)), handler::listPeople)
            .andRoute(POST("/person").and(contentType(APPLICATION_JSON)), handler::createPerson);
  }

}
