package com.digitalgamestore.dgsbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DgsBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DgsBeApplication.class, args);
	}

}
