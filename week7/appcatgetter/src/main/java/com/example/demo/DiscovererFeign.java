package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "appcatdiscoverer")
public interface DiscovererFeign {
	
	@GetMapping("/appcaturl")
	public String getUrl();

}
