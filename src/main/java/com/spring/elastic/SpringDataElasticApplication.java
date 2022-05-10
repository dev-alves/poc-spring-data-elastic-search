package com.spring.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.elastic.domain.repository.AddressRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AddressRepository.class)
public class SpringDataElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataElasticApplication.class, args);
	}

}
