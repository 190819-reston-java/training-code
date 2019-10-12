package com.revature.repositories;

import java.util.List;

import com.revature.models.IActor;
import com.revature.models.IDirector;
import com.revature.models.IMovie;
import com.revature.models.MovieGenre;

public interface IMovieRepository {

	List<IMovie> findAll();

	IMovie findOne(int id);

	List<IMovie> findByActor(IActor actor);

	List<IMovie> findByDirector(IDirector director);

	List<IMovie> findByGenre(MovieGenre genre);

	IMovie save(IMovie movie);

}