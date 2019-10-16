package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class DiscovererApplication {
	
	@Autowired
	EurekaClient ec;

	public static void main(String[] args) {
		SpringApplication.run(DiscovererApplication.class, args);
	}
	
	@GetMapping("/appcaturl")
	public String getAppcatUrl() {
		return ec.getNextServerFromEureka("appcat", false).getHomePageUrl();
	}

}
