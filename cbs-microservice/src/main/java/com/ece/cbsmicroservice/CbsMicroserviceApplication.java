package com.ece.cbsmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController

public class CbsMicroserviceApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(CbsMicroserviceApplication.class, args);
	}

	@GetMapping("/cbs")
	public String welcome() {
		return "welcome CBS microservice";
	}

	@PostMapping("/accenq")
	public String accountEnquiry(@RequestBody String msg) {

		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		System.out.println("Request came ::::" + "the PORT::" + port);
		System.out.println("the  incoming the data was " + msg);

		
		 msg="The originator has been registred with the port \t"+port+"the org name"+msg;
		return msg;

	}

}
