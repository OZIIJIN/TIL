package org.study.spring.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

	private static final String REDISSON_HOST_PREFIX = "redis://";

	// 외부 설정 파일(yml)에서 속성 값을 주입 받음
	@Value("${spring.data.redis.host}")
	private String redisHost;

	@Value("${spring.data.redis.port}")
	private int redisPort;


	@Bean // 이 메서드가 반환하는 객체가 Spring 컨테이너에 의해 관리되는 Bean 이 됨
	public RedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost,
			redisPort);
		return new LettuceConnectionFactory(configuration);
	}
	// RedisStandaloneConfiguration: Redis 서버의 호스트와 포트를 설정하는 데 사용됨
	// LettuceConnectionFactory: Redis 와의 연결을 관리하는 팩토리 클래스. RedisStandaloneConfiguration 을 사용하여 Redis 서버와의 단일 연결을 설정

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		return redisTemplate;
	}
	// RedisTemplate<String, Object>: Redis 데이터베이스와 상호 작용하기 위한 템플릿. 키와 값, 해시 키와 해시 값 모두 문자열로 직렬화함
	// setConnectionFactory(redisConnectionFactory()): 이전에 정의한 RedisConnectionFactory

	@Bean
	public RedissonClient redissonClient() {
		Config config = new Config();
		config.useSingleServer()
			.setAddress(REDISSON_HOST_PREFIX + redisHost + ":" + redisPort);

		return Redisson.create(config);
	}
}

