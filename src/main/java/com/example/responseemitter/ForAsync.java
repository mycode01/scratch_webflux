//package com.example.responseemitter;
//
//import java.io.IOException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//@Slf4j
//@Component
//public class ForAsync {
//
//  @Async
//  public void doit(ResponseBodyEmitter emitter, int i) throws IOException, InterruptedException {
//    for (int j = 0; j < i; j++) {
//      emitter.send("<p>j : "+j+"</p>");
//      log.debug(""+j);
//      Thread.sleep(1000l);
//    }
//  }
//}
