package com.redispoc.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Duration;
import java.util.HashMap;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EntityScan("com.redispoc.redisdemo.core.model")
public class RedisDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedisDemoApplication.class, args);
  }

  @Bean
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    RedisCacheConfiguration defaultConfig = RedisCacheConfiguration
        .defaultCacheConfig()
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));

    return RedisCacheManager.builder(connectionFactory)
        .withInitialCacheConfigurations(new HashMap<String, RedisCacheConfiguration>() {{
          put("tickets", defaultConfig
              .entryTtl(Duration.ofMinutes(2)));
          put("customers", defaultConfig
              .entryTtl(Duration.ofMinutes(4)));
        }})
        .transactionAware()
        .build();
  }

  @Bean
//  @Bean(name = "redisTemplate")
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setHashKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.setHashValueSerializer(RedisSerializer.json());
    redisTemplate.setConnectionFactory(factory);

    return redisTemplate;
  }
}