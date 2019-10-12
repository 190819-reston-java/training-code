package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.IActor;
import com.revature.models.IDirector;
import com.revature.models.IMovie;
import com.revature.models.MovieGenre;
import com.revature.repositories.IMovieRepository;

@Service
public class MovieService implements IMovieService {
	
	@Autowired
	private IMovieRepository movieRepository;
	
	@Override
	public List<IMovie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public IMovie findOne(IMovie movie) {
		return movieRepository.findOne(movie.getId());
	}
	
	@Override
	public IMovie save(IMovie movie) {
		return movieRepository.save(movie);
	}
	
	@Override
	public List<IMovie> findByDirector(IDirector director) {
		return movieRepository.findByDirector(director);
	}
	
	@Override
	public List<IMovie> findByActor(IActor actor) {
		return movieRepository.findByActor(actor);
	}
	
	@Override
	public List<IMovie> findByGenre(MovieGenre genre) {
		return movieRepository.findByGenre(genre);
	}
}
