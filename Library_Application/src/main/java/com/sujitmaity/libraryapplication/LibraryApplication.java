package com.sujitmaity.libraryapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		//
		//		BookClass book = new BookClass();
		//		book.setBookId(101);
		//		book.setTitle("Maths");
		//		book.setAuthorName("Sujit");
		//		book.setYearOfPublish(2022);
		//
		//		RestTemplate temp = new RestTemplate();
		//
		//		//		ResponseEntity<BookClass> boo= temp.getForEntity("http://localhost:8080/bookclass/get/102", BookClass.class);
		//		//		System.out.println("Niklo Tum:"+boo);
		//
		//
		//		HttpEntity<BookClass> boo= new HttpEntity<BookClass>(book);
		//		System.out.println("AAja Bhai: "+boo);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sujitmaity.libraryapplication.controller")).build();

	}
	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}

}
