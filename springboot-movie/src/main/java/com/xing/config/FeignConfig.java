package com.xing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Contract;
import feign.Feign;

@Configuration
public class FeignConfig {

	//配置是在FeignClient中的接口中使用Feign自带的注解
	@Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
   }
	
	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	} 
	
}
