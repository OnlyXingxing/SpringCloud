package com.xing.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xing.user.entity.User;

@Mapper
public interface UserMapper {
	 //这里的表名区分大小写 
	 @Select("SELECT * FROM user WHERE NAME = #{name}")
	 User selectByName(@Param("name") String name);
	 
	 @Select("SELECT * FROM user WHERE nameEn = #{nameEn}")
	 User selectByNameEn(@Param("nameEn") String nameEn);
	 
	 @Insert("insert into user (name,nameEn,age) value (#{name},#{nameEn},#{age})")
	 int insertUser(@Param("name") String name ,@Param("nameEn") String nameEn ,@Param("age") int age);

}
