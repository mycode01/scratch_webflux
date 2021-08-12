package com.example.scratchwebflux;

import lombok.SneakyThrows;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TestBeans{
  @Bean
  public Subscriber<Person> tester(){
    return new Subscriber<Person>() {
      @SneakyThrows
      @Override
      public void onSubscribe(Subscription s) {
        Thread.sleep(1000l);
        System.out.println("subscribed:: ");
      }

      @SneakyThrows
      @Override
      public void onNext(Person person) {
        Thread.sleep(1000l);
        System.out.println("subscribed:: ");
        System.out.println(person.name);
      }

      @SneakyThrows
      @Override
      public void onError(Throwable t) {
        System.out.println("onError:: "+t);
      }

      @SneakyThrows
      @Override
      public void onComplete() {
        System.out.println("onComplete:: ");
      }
    };
  }

  @Bean
  public Flux<Object> stream(){
    return Flux.create(fluxSink -> {
      while(true){
        fluxSink.next(System.currentTimeMillis());
      }
    });
  }
}
