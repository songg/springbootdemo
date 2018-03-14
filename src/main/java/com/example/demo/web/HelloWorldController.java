package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${com.example.demo.title}")
	private String title;

	
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/userinfo")
	public User getUser() {
		User u = new User();
		u.setName("锁猪");
		return u;
	}
	
	@RequestMapping("/title")
	public String getTitle() {
		logger.debug("query title");
		return title;
	}
}
