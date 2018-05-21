package com.example.Chapter9;

import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class Chapter9ApplicationTests {

	@Autowired
	private UserRepository userRepository;


	@Test
	public void findAllUsers() {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void findUserById() {
		Optional<User> user = userRepository.findById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = new User(0,"Okan","demirtas@gmail.com");
		User savedUser = userRepository.save(user);

		Optional<User> newUser = userRepository.findById(savedUser.getId());

		assertEquals("Okan",newUser.get().getName());

	}

	@Test
	public void getUsersSortByName() {
		Sort sort = new Sort(Sort.Direction.ASC,"name");
		List<User> users = userRepository.findAll(sort);
		assertNotNull(users);
	}

	@Test
	public void getUsersSortByNameAscAndIdDesc() {
		Sort.Order order1 = new Sort.Order(Sort.Direction.ASC,"name");
		Sort.Order order2 = new Sort.Order(Sort.Direction.DESC,"id");
		Sort sort = new Sort(order1,order2);

		List<User> users = userRepository.findAll(sort);
		assertNotNull(users);
	}

	@Test
	public void getUsersByPage() {
		Sort sort = new Sort(Sort.Direction.ASC,"name");
		int size = 25;
		int page = 0;

		Pageable pageable = new PageRequest(page,size,sort);
		Page<User> usersPage = userRepository.findAll(pageable);
		System.out.println(usersPage.getTotalElements());
		System.out.println(usersPage.getTotalPages());
		System.out.println(usersPage.hasNext());
		System.out.println(usersPage.hasPrevious());
		List<User> usersList = usersPage.getContent() ;
		assertNotNull(usersList);

	}

}
