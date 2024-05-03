package org.study.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	//@Configuration 을 통해 설정 클래스 생성 가능

	//@Configuration 과 class 명 Configuration -> 중복되면 안됨

	// 아래 Bean 을 등록하기 위해 @Configuration 이 사용됨
	// @Configuration 안에는 @Component 가 존재 -> 스프링은 컴포넌트 스캔(Component Scan)을 사용해 @Component 어노테이션이 있는 클래스들을 찾아서 자동으로 빈 등록
	// 따라서, 직접 개발한 클래스를 빈으로 편리하게 등록하고자 하는 경우는 @Component 를 활용

	// 최종 프로젝트 예시 - RedisConfig
//	@Configuration
//	public class RedisConfig {
//
//		private static final String REDISSON_HOST_PREFIX = "redis://";
//
//		@Value("${spring.data.redis.host}")
//		private String redisHost;
//
//		@Value("${spring.data.redis.port}")
//		private int redisPort;
//
//
//		@Bean
//		public RedisConnectionFactory redisConnectionFactory() {
//			RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost,
//				redisPort);
//			return new LettuceConnectionFactory(configuration);
//		}
//
//		@Bean
//		public RedisTemplate<String, Object> redisTemplate() {
//			RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//			redisTemplate.setKeySerializer(new StringRedisSerializer());
//			redisTemplate.setValueSerializer(new StringRedisSerializer());
//			redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//			redisTemplate.setHashValueSerializer(new StringRedisSerializer());
//			redisTemplate.setConnectionFactory(redisConnectionFactory());
//			return redisTemplate;
//		}
//
//		@Bean
//		public RedissonClient redissonClient() {
//			Config config = new Config();
//			config.useSingleServer()
//				.setAddress(REDISSON_HOST_PREFIX + redisHost + ":" + redisPort);
//
//			return Redisson.create(config);
//		}
//	}

}