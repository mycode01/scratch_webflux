//package com.example.responseemitter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
//
//@EnableAsync
//@SpringBootApplication(scanBasePackages = "com.example.responseemitter")
//public class Application {
//
//  public static void main(String[] args) {
//    SpringApplication.run(Application.class, args);
//  }
//
//
//  @RestController
//  static class DefaultController{
//    @Autowired
//    ForAsync forAsync;
//    @GetMapping("/a")
//    public ResponseBodyEmitter a(Integer i) throws Exception{
//      ResponseBodyEmitter emitter = new ResponseBodyEmitter();
//      forAsync.doit(emitter, i);
//      return emitter;
//    }
//  }
//}
