package com.xing.movie.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xing.movie.entity.Movie;

@Mapper
public interface MovieMapper {
	 //这里的表名区分大小写 
	 @Select("SELECT * FROM movie WHERE NAME = #{name}")
	 Movie selectByName(@Param("name") String name);
	 
	 @Insert("insert into movie (name,nameEn,age) value (#{name},#{nameEn},#{updatetime})")
	 int insertMovie(@Param("name") String name ,@Param("nameEn") String nameEn ,@Param("updatetime") Date updatetime);
	 
	 @Delete("delete from movie where name =#{name}")
	 int deleteByName(@Param("name") String name);

}
