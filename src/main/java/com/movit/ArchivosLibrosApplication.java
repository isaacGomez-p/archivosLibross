package com.movit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ComponentScan("com.movit")
@EntityScan("com.movit.entity")
@EnableJpaRepositories("com.movit.repository")
public class ArchivosLibrosApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		SpringApplication.run(ArchivosLibrosApplication.class, args);		
	}

}
