package com.GerenciadorItensSustentaveis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ComponentScan(basePackages = {"com.GerenciadorItensSustentaveis"})
@EnableJpaRepositories(basePackages = {"com.GerenciadorItensSustentaveis.Repository"}) 
@EntityScan(basePackages = {"com.GerenciadorItensSustentaveis.Model"})


@SpringBootApplication
public class GerenciadorItensSustentaveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorItensSustentaveisApplication.class, args);
	}

}
