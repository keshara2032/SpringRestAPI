package com.country.countryrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class CountryRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryRestApiApplication.class, args);
	}

}
