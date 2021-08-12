package com.example.scratchwebflux2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@EnableAsync
@SpringBootApplication(scanBasePackages = "com.example.scratchwebflux2")
public class Application {

  @Bean
  public Executor asyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(10);
    executor.setMaxPoolSize(10);
    executor.setQueueCapacity(500);
    executor.initialize();
    return executor;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @RestController
  public static class DefaultController {

    static Queue<DeferredResult> q = new ConcurrentLinkedQueue<>();

    @GetMapping("/a")
    public DeferredResult<String> a() {
      DeferredResult<String> a = new DeferredResult(60000L);
      q.add(a);
      return a;
    }

    @GetMapping("/b")
    public String b() {
      return String.valueOf(q.size());
    }

    @GetMapping("/c")
    public String c(String name) {
      for (DeferredResult<String> d : q) {
        d.setResult("hello "+name);
      }
      return "ok";
    }
  }
}
