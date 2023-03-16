package com.example.timedealserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TimeDealServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeDealServerApplication.class, args);
	}

}
