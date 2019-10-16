package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "appcat")
public interface AppcatFeign {
	
	@GetMapping("/cats")
	public String getCats();

}
