package com.example.demo;

import com.example.entity.Sender;
import com.example.test.TestUser;
import com.example.test.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private Sender sender;

	@Autowired
	private User user;

	@Autowired
	private TestUser testUser;

	@Test
	public void hello() {
		System.out.println(testUser.getUserName());
	}



}
