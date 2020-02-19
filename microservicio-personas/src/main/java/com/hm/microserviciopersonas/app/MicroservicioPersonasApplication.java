package com.hm.microserviciopersonas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"com.hm.commonsmiembros.models.entity",
			 "com.hm.microserviciopersonas.app.models.entity"})
@ComponentScan({"com.hm.commonsutils.exceptions",
				"com.hm.microserviciopersonas.app.*"})
public class MicroservicioPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPersonasApplication.class, args);
	}

}
