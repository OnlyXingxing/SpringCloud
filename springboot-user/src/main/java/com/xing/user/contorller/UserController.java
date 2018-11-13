package com.xing.user.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.xing.user.entity.User;
import com.xing.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="用户接口", produces = MediaType.APPLICATION_JSON_VALUE) 
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "查询用户By中文名", notes = "查询用户By中文名")//方法说明
//	@ApiResponses({ @ApiResponse(code = CommonStatus.OK, message = "操作成功"),
//        @ApiResponse(code = CommonStatus.EXCEPTION, message = "服务器内部异常"),
//        @ApiResponse(code = CommonStatus.FORBIDDEN, message = "权限不足") })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = User.class)})//响应数据说明，可以有多个
	@ApiImplicitParam(name = "name", value = "用户名", paramType = "path", required = true, dataType = "String")
	//produces = { "application/json;charset=UTF-8" } 这段代码是因为集成了EurekaServer，又需要jackson-dataformat-xml这个依赖，如果不设置这段代码，会返回xml格式，而不是json
	@GetMapping(value = "/findByName/{name}",produces = { "application/json;charset=UTF-8" })
	public User findByName(@PathVariable String name) {
		System.out.println("----------------------------"+name);
		return userService.findByName(name);
	}
	
	@ApiOperation(value = "查询用户By英文名", notes = "查询用户By英文名")//方法说明
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = User.class)})//响应数据说明，可以有多个
	@ApiImplicitParam(name = "nameEn", value = "英文用户名", paramType = "path", required = true, dataType = "String")
	//produces = { "application/json;charset=UTF-8" } 这段代码是因为集成了EurekaServer，又需要jackson-dataformat-xml这个依赖，如果不设置这段代码，会返回xml格式，而不是json
	@GetMapping(value = "/findByNameEn/{nameEn}",produces = { "application/json;charset=UTF-8" })
	public User findByNameEn(@PathVariable String nameEn) {
		System.out.println("en----------------------------"+nameEn);
		return userService.findByNameEn(nameEn);
	}
}
