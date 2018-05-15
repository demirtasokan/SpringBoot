package com.example.Chapter4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter4ApplicationTests {

	@Autowired
	private DataSourceConfig dataSourceConfig;

	@Test
	public void testContextLoads() {
		System.out.println(dataSourceConfig);
	}

	@Test
	public void contextLoads() {
	}

}
