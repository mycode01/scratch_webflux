package com.example.asyncresttemplate;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

@SpringBootApplication(scanBasePackages = "com.example.asyncresttemplate")
public class AsyncTemplate {

  public static void main(String[] args) {

    System.setProperty("server.port","8081");
    SpringApplication.run(AsyncTemplate.class, args);
  }

  @RestController
  static class DefaultController {

    AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));
    //netty cli

    @GetMapping("gorest")
    public ListenableFuture<ResponseEntity<String>> get(@RequestParam String idx) {
      return asyncRestTemplate.getForEntity("http://localhost:8080/hello?req={req}", String.class, "hello " + idx);
    }
  }

}
