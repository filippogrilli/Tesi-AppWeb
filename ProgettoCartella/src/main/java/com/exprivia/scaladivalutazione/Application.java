package com.exprivia.scaladivalutazione;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
/*@ComponentScan(basePackages = Controller)
@ComponentScan(basePackages = Repository)*/
//@EnableJpaAuditing
public class Application{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
