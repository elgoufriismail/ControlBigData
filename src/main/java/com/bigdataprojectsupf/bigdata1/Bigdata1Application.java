package com.bigdataprojectsupf.bigdata1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bigdataprojectsupf.bigdata1.entity.RichestPpl;
import com.bigdataprojectsupf.bigdata1.repo.RichestPplRepository;

@SpringBootApplication
public class Bigdata1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bigdata1Application.class, args);
	}
	@Bean
	public ApplicationRunner applicationRunner(RichestPplRepository richestPplRepository){
		return args->{
			System.out.println(richestPplRepository);
				
		};
	}
}
