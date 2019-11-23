package com.ece.originatormicroservice;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class OriginatorMicroserviceApplication {

	
	Logger log = LoggerFactory.getLogger(OriginatorMicroserviceApplication.class);

	@Autowired
	RestTemplate  restTemplate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(OriginatorMicroserviceApplication.class, args);
	}
	
	@GetMapping("/org")
	public String welcome() {
		
	return "welcome originator service";	
	}
	
	@GetMapping("/saveorg")
	public String  saveorg(@RequestParam("orgname") String reqStr) {
	
		//final String  url="http://cbsservice/accenq";
		
		final String  url="http://zuulserver/cbsapi/accenq";

		
		
		
		String response = null;
		try {
			log.info("call to core banking system with {} ", reqStr);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(reqStr, headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			response = responseEntity.getBody();

			log.info("getting response from core banking system {} ", response);
		}

		catch (Exception e) {
			log.error(ExceptionUtils.getFullStackTrace(e));

		}
		return response;
	}
	
	@Bean
	@LoadBalanced
   public RestTemplate restTemplate() {
		
		return new RestTemplate();

	}


}
