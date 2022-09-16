package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.demo.SpringbootHibernateApplication;

@SpringBootApplication
public class SpringbootHibernateApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SpringbootHibernateApplication.class);
		}
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}
}
