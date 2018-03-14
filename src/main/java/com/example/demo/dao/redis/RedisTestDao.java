package com.example.demo.dao.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class RedisTestDao {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public void add(User user) {
		redisTemplate.opsForValue().set(String.valueOf(user.getId()), user.getName(), 1, TimeUnit.MINUTES);
	}

	public String get(long id) {
		String userString = redisTemplate.opsForValue().get(String.valueOf(id));
		return userString;
	}
}
