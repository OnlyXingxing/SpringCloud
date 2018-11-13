package com.xing.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.xing.config.RibbonConfig;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "xing-user" , configuration = RibbonConfig.class)
@EnableFeignClients(basePackages = {"com.xing.movie"})
@EnableCircuitBreaker //对Hystrix熔断机制的支持
public class SpringDemoApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
