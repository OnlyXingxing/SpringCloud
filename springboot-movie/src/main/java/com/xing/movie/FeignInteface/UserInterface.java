package com.xing.movie.FeignInteface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xing.config.FeignConfig;
import com.xing.movie.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "xing-user" ,fallback = UserInterfaceFallback.class,configuration = FeignConfig.class)//服务名
public interface UserInterface {
	@RequestMapping(value ="/user/findByNameEn/{nameEn}" ,method =RequestMethod.GET ) //必须使用RequestMapper,使用GetMapping启动报错
	//@RequestLine("GET /user/findByNameEn/{nameEn}")
	public User findByNameEn(@PathVariable("nameEn") String nameEn);//@PathVariable后面需要指定nameEn，不然可能报错
	
}
//不一定要内部类可以是外部类
@Component
class UserInterfaceFallback implements UserInterface {
	@Override
	public User findByNameEn(String nameEn) {
		User user = new User();
		user.setName("");
		user.setNameEn("");
		user.setId(0);
		return user;
	}
}
