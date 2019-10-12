package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.IMovie;
import com.revature.services.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
	@GetMapping
	public List<IMovie> findAll() {
		return movieService.findAll();
	}
	
	@PostMapping
	public IMovie create(@RequestBody IMovie movie) {
		return movieService.save(movie);
	}
	
	@PutMapping
	public IMovie update(@RequestBody IMovie movie) {
		return movieService.save(movie);
	}
}
