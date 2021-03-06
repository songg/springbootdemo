package com.example.demo.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(HelloWorldController.class) 
public class HelloTest {
//	private MockMvc mockMvc;
	
	@Autowired
	private MockMvc mockMvc;

//	@Before
//	public void setUp() throws Exception {
//		mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
//	}

	@Test
	public void getHello() throws Exception {
		// mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
		// .andExpect(status().isOk()).andExpect(content().string(equalTo("Hello
		// World")));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print())
        .andReturn();
	}
}
