package com.example.Chapter6;

import com.example.Chapter6.domain.User;
import com.example.Chapter6.mappers.UserAnnotationMapper;
import com.example.Chapter6.mappers.UserMapper;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter6ApplicationTests {

//	@Autowired private UserMapper userMapper;

	@Autowired
	private UserAnnotationMapper userMapper;

	@Test
	public void findAllUsers() {

		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void findUserById(){
		User user = userMapper.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = new User("Okkan","okan@gmial.com");
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("Okkan",newUser.getName());
	}
	@Test
	public void contextLoads() {
	}

}
