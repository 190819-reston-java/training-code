package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RestController
public class AppcatgetterApplication {
	
	@Autowired
	AppcatFeign af;
	
	@Autowired
	DiscovererFeign df;

	public static void main(String[] args) {
		SpringApplication.run(AppcatgetterApplication.class, args);
	}
	
	@GetMapping("/feigndemo")
	public String wackyRouting() {
		return af.getCats() + df.getUrl();
	}

}
