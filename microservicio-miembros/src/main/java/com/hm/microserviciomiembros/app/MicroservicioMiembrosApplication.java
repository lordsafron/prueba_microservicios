package com.hm.microserviciomiembros.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"com.hm.commonsmiembros.models.entity"})
@ComponentScan({"com.hm.commonsutils.exceptions",
				"com.hm.microserviciomiembros.app.*"})	
public class MicroservicioMiembrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioMiembrosApplication.class, args);
	}

}
