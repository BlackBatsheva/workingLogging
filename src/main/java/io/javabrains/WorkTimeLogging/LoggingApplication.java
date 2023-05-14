package io.javabrains.WorkTimeLogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component

public class LoggingApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoggingApplication.class, args);
	}

}
