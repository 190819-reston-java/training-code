package com.revature.services;

import java.util.List;

import com.revature.models.IActor;
import com.revature.models.IDirector;
import com.revature.models.IMovie;
import com.revature.models.MovieGenre;

public interface IMovieService {

	List<IMovie> findAll();

	IMovie findOne(IMovie movie);

	IMovie save(IMovie movie);

	List<IMovie> findByDirector(IDirector director);

	List<IMovie> findByActor(IActor actor);

	List<IMovie> findByGenre(MovieGenre genre);

}