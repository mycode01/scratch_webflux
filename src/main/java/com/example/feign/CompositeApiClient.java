package com.example.feign;


import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@FeignClient(name = "compositor", url = "${composite.api.path.prefix:localhost:8082/composite}", configuration = CompositorApiConfig.class)
@FeignClient(name = "compositor", configuration = CompositorApiConfig.class)
//@FeignClient("compositor")
public interface CompositeApiClient {

//  @PostMapping("/compose/")
  @RequestLine("POST /composite/compose")
  Mono<MakeBlueprintRes> composeImages(@RequestBody MakeBlueprintReq req);
//  @PostMapping("/sleep/")
  @RequestLine("POST /composite/sleep")
  Mono<MakeBlueprintRes> timeout(@RequestBody MakeBlueprintReq req);
}