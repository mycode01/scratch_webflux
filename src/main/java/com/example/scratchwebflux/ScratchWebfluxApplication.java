package com.example.scratchwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.scratchwebflux")
public class ScratchWebfluxApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScratchWebfluxApplication.class, args);
  }

}
