package org.study.spring.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	//@Configuration 과 class 명 Configuration -> 중복되면 안됨

	// 아래 Bean 을 등록하기 위해 @Configuration 이 사용됨
	// @Configuration 안에는 @Component 가 존재 -> 스프링은 컴포넌트 스캔(Component Scan)을 사용해 @Component 어노테이션이 있는 클래스들을 찾아서 자동으로 빈 등록
	// 따라서, 직접 개발한 클래스를 빈으로 편리하게 등록하고자 하는 경우는 @Component 를 활용

//	@Bean
//	public Hello hello() {
//		return new Hello();
//	}

}