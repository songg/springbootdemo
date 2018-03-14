package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.redis.RedisTestDao;
import com.example.demo.entity.User;

@RestController
public class RedisTestController {
	
	@Autowired
	private RedisTestDao redisTestDao;
	
	
	@RequestMapping("/set")
	public String set() {
		User user = new User();
		user.setId(1);
		user.setName("suozhu");
		redisTestDao.add(user);
		return "hello";
	}
	
	@RequestMapping("/get")
	public String get() {
		return redisTestDao.get(1l);
	}

}
