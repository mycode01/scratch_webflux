package com.example.asyncresttemplate;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class Tester {


  static AtomicInteger counter = new AtomicInteger(0);

  public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    ExecutorService es = Executors.newFixedThreadPool(100);

    RestTemplate re = new RestTemplate();
    String url = "http://localhost:8081/gorest?idx={idx}";
    CyclicBarrier barrier = new CyclicBarrier(101);


    for (int i = 0; i < 100; i++) {
      es.submit(()->{
        int idx = counter.addAndGet(1);
        barrier.await();
        log.info("thread {}", idx);
        String res = re.getForObject(url, String.class, idx);
        log.info(res);
        return null;
      });
    }
    es.shutdown();
  }

}
