package com.xing.movie.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xing.movie.dao.MovieMapper;
import com.xing.movie.entity.Movie;

@Service
public class MovieService {
	
	@Autowired
	private MovieMapper movieMapper;
		
	@Transactional
	public Movie findByName(String name) {
		return movieMapper.selectByName(name);
	}
	@Transactional
	public int saveMovie(String name,String nameEn,Date updatetime) {
		return movieMapper.insertMovie(name, nameEn, updatetime);
	}
	@Transactional
	public int deleteByName(String name) {
		return movieMapper.deleteByName(name);
	}
}
