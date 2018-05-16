package com.example.Chapter5;

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
@SpringBootTest(classes = Chapter5App.class)
public class Chapter5ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test public void findAllUsers() {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void findUserById() {
		User user = userRepository.findUserById(1);
		assertNotNull(user);
	}
	@Test
	public void createUser() {
		User user = new User(0, "Siva", "siva@gmail.com");
		User savedUser = userRepository.create(user);
		User newUser = userRepository.findUserById(savedUser.getId());
		assertEquals("Siva", newUser.getName());
		assertEquals("siva@gmail.com", newUser.getEmail());
	}

	@Test
	public void contextLoads() {
	}

}
