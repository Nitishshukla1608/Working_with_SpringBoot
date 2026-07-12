package com.taskflow.crudSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication()
public class C rudSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootDemoApplication.class, args);
		System.out.println ("Hello");
	}

}
