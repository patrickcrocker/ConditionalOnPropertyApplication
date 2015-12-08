package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

@SpringBootApplication
public class ConditionalOnPropertyApplication {

	@Autowired
	ConfigurableEnvironment env;

	@Autowired
	public void addPropertySource() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testvalue", "wasabi");

		env.getPropertySources().addFirst(new MapPropertySource("mapProperties", map));
	}

	/**
	 * Hmm... seems to be broken.
	 * 
	 * Can only get this to to run if matchIfMissing = true even though we can
	 * clearly see the testvalue in the env.
	 * 
	 * @param env
	 * @return
	 */
	@Bean(name = "testvalueBean")
	@ConditionalOnProperty(name = "testvalue", matchIfMissing = false)
	public String testBean() {

		System.out.println("testvalue=" + env.getProperty("testvalue"));

		return env.getProperty("testvalue");
	}

	public static void main(String[] args) {
		SpringApplication.run(ConditionalOnPropertyApplication.class, args);
	}
}
