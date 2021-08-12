package com.example.feign;

import feign.Feign;
import feign.Request.Options;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.reactive.ReactorFeign;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.example.feign")
@Configuration
public class CompositorApiConfig {

  @Bean
  Encoder compositorEncoder() {
//    Gson gson = new GsonBuilder()
//        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//        .create();
//    return new GsonEncoder(gson);
    return new SpringEncoder(HttpMessageConverters::new);
  }

  @Bean
  Decoder compositorDecoder() {
    return new SpringDecoder(HttpMessageConverters::new);
  }

//  @Bean
//  public Feign.Builder CompositorApiFeignBuilder(){
//    return ReactorFeign.builder().encoder(compositorEncoder()).decoder(compositorDecoder())
//        .options(new Options(120, TimeUnit.SECONDS, 120, TimeUnit.SECONDS, false));
//  }

  @Bean
  @ConditionalOnMissingBean
  public CompositeApiClient buildCompositeApiClient() {
    return ReactorFeign.builder()
        .decoder(compositorDecoder())
        .encoder(compositorEncoder())
        .target(CompositeApiClient.class, "localhost:8082");
  }
}
