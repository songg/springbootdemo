package com.example.demo.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.mysql.UserRepository;
import com.example.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void testFindByName() {
		User u = new User();
		u.setName("锁猪");
		
		User u2 = new User();
		u2.setName("锁爸");
		userRepository.save(u);
		userRepository.save(u2);
		
		Assert.assertEquals("锁猪", userRepository.findByName("锁猪").getName());
		Assert.assertNotEquals("锁猪", userRepository.findByName("锁爸").getName());
	}
}
