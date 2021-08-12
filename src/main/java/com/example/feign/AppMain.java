package com.example.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@SpringBootApplication
public class AppMain implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(com.example.feign.AppMain.class, args).close();
  }

  @Autowired
  CompositeApiClient buildCompositeApiClient;

  @Override
  public void run(String... args) throws Exception {
    Mono.just(new MakeBlueprintReq("", "", "", "", "",
        0d, 0d, "", 0, 9, "", 0, "", "",
        "", ""))
    .flatMap(buildCompositeApiClient::composeImages)
    .doOnNext(r->{
      System.out.println(r.getPathPreview());
    }).subscribe();

    Thread.sleep(30000l);

    ;
  }
}