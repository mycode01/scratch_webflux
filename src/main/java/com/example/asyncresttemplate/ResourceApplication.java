package com.example.asyncresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.example.asyncresttemplate")
public class ResourceApplication {

  public static void main(String[] args) {
    System.setProperty("server.tomcat.max-threads", "1");
    SpringApplication.run(ResourceApplication.class, args);
  }

  @RestController
  static class DefaultController {
    @GetMapping("/hello")
    public String hello(String req) throws InterruptedException {
      Thread.sleep(2000l);
      return req;
    }
  }


}
