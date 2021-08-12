package com.example.scratchwebflux;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import lombok.SneakyThrows;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DefaultHandler {

  private final PersonRepository repository;
  private final Subscriber<Person> tester;
  private final Flux<Object> stream;

  public DefaultHandler(PersonRepository repository,
      Subscriber<Person> tester,
      Flux<Object> stream) {
    this.repository = repository;
    this.tester = tester;
    this.stream = stream;
  }

  public Mono<ServerResponse> listPeople(ServerRequest request) {
    return Mono.just(repository.findAll()).flatMap(
        people -> ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Person.class));
  }

  public Mono<ServerResponse> createPerson(ServerRequest request) {
    return request.bodyToMono(Person.class)
        .flatMap(person -> Mono.just(repository.save(person)))
        .map(p->{
          stream.subscribe(System.out::println);
          stream.publish();
          return p;
        })
        .flatMap(person -> ServerResponse.ok().bodyValue(person));
  }

  public Mono<ServerResponse> getPerson(ServerRequest request) {
    return request.bodyToMono(Long.class)
        .flatMap(i -> Mono.fromCallable(() -> repository.findById(i)))
        .flatMap(
            person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(person, Person.class));
    // onerror, otherwiseifempty
  }


}
