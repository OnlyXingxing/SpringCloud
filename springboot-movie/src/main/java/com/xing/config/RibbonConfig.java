package com.xing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
* Copyright: Copyright (c) 2018 LanRu-Caifu
* @ClassName: RibbonConfig.java
* @Description: 自定义ribbon配置类
* @version: v1.0.0
* @author: zjx
* @date: 2018年11月2日 上午10:08:36
 */

@Configuration
public class RibbonConfig {
	
	@Autowired
    IClientConfig config;
	
	@Bean
	@ConditionalOnMissingBean
	public IRule ribbonRule(IClientConfig config) {
		System.out.println("-------ribbon自定义随机------");
		return new RandomRule();
	}
}
