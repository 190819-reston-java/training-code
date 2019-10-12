package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.ActorMovie;
import com.revature.models.IActor;
import com.revature.models.IDirector;
import com.revature.models.IMovie;
import com.revature.models.Movie;
import com.revature.models.MovieGenre;

@Repository
public class MovieRepository implements IMovieRepository {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<IMovie> findAll() {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<IMovie> movies = s.createCriteria(IMovie.class).list();
		
		return movies;
	}
	
	@Override
	public IMovie findOne(int id) {
		Session s = sf.getCurrentSession();
		
		IMovie movie = (IMovie) s.get(IMovie.class, id);
		
		return movie;
	}
	
	@Override
	public List<IMovie> findByActor(IActor actor) {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ActorMovie> result = (List<ActorMovie>)s.createCriteria(ActorMovie.class)
									.add(Restrictions.eq("actor", actor.getId())).list();
		
		List<IMovie> movies = new ArrayList<>();
		for(ActorMovie am : result) {
			movies.add(am.getMovie());
		}
		
		return movies;
	}

	@Override
	public List<IMovie> findByDirector(IDirector director) {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<IMovie> movies = (List<IMovie>) s.createCriteria(Movie.class)
									.add(Restrictions.eq("director", director.getId())).list();
		
		return movies;
	}
	
	@Override
	public List<IMovie> findByGenre(MovieGenre genre) {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<IMovie> movies = (List<IMovie>) s.createCriteria(Movie.class)
									.add(Restrictions.eq("genre", genre.ordinal())).list();
		
		return movies;
	}
	
	@Override
	public IMovie save(IMovie movie) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(movie);
		
		return movie;
	}
}
