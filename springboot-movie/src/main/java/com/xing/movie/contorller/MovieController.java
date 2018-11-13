package com.xing.movie.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xing.movie.FeignInteface.UserInterface;
import com.xing.movie.entity.Movie;
import com.xing.movie.entity.User;
import com.xing.movie.service.MovieService;
import org.springframework.http.MediaType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="电影接口", produces = MediaType.APPLICATION_JSON_VALUE) 
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserInterface userInterface;
	
	@ApiOperation(value = "查询电影", notes = "查询电影")//方法说明
//	@ApiResponses({ @ApiResponse(code = CommonStatus.OK, message = "操作成功"),
//        @ApiResponse(code = CommonStatus.EXCEPTION, message = "服务器内部异常"),
//        @ApiResponse(code = CommonStatus.FORBIDDEN, message = "权限不足") })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = Movie.class)})//响应数据说明，可以有多个
	@ApiImplicitParam(name = "name", value = "电影名", paramType = "path", required = true, dataType = "String")
	@GetMapping(value = "/findByName/{name}",produces = { "application/json;charset=UTF-8" })
	public Movie findByName(@PathVariable String name) {
		return movieService.findByName(name);
	}
	
	@HystrixCommand(fallbackMethod = "fallbackfindUserByNameEn") //ribbon使用Hystrix
	@ApiOperation(value = "查询用户ByName", notes = "查询用户By中文名")//方法说明
	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = Movie.class)})//响应数据说明，可以有多个
	@ApiImplicitParam(name = "name", value = "用户名", paramType = "path", required = true, dataType = "String")
	@GetMapping(value = "/findUserByName/{name}",produces = { "application/json;charset=UTF-8" })
	public User findUserByName(@PathVariable String name) {
		return this.restTemplate.getForObject("http://xing-user/user/findByName/"+name, User.class);
	}
	
	/**
	 * 
	* @Function: MovieController.java
	* @Description: 使用Feign调用user服务
	* @param:name,英文名
	* @return：user对象
	* @throws：null
	* @version: v1.0.0
	* @author: TR
	* @date: 2018年11月5日 下午3:55:16 
	 */
	@ApiOperation(value = "查询用户", notes = "查询用户By英文名")//方法说明
	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = Movie.class)})//响应数据说明，可以有多个
	@ApiImplicitParam(name = "nameEn", value = "用户英文名", paramType = "path", required = true, dataType = "String")
	@GetMapping(value = "/findUserByNameEn/{nameEn}",produces = { "application/json;charset=UTF-8" } )
	public User findUserByNameEn(@PathVariable String nameEn) {
		User user = userInterface.findByNameEn(nameEn);
		System.out.println("findUserByNameEn----"+user);
		return user;
	}
	
	public User fallbackfindUserByNameEn(@PathVariable String nameEn) {
		return new User("数据库查询为空", nameEn, 0);
	}
}
