package com.movit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ArchivosLibrosApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private BCryptPasswordEncoder byc;
	
	@Test
	void ver() {
		System.out.println("............"+byc.encode("12345"));
	}

}
