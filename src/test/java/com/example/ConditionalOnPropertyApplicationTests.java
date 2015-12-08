package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConditionalOnPropertyApplication.class)
public class ConditionalOnPropertyApplicationTests {

	@Autowired
	@Qualifier("testvalueBean")
	private String testvalueBean; 
	
	@Test
	public void contextLoads() {
		assertEquals("wasabi", testvalueBean);
	}

}
