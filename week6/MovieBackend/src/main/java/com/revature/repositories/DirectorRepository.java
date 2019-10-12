package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.IDirector;

@Repository
public class DirectorRepository implements IDirectorRepository {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<IDirector> findAll() {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<IDirector> directors = s.createCriteria(IDirector.class).list();
		
		return directors;
	}
	
	@Override
	public IDirector findOne(int id) {
		Session s = sf.getCurrentSession();
		
		IDirector director = (IDirector) s.get(IDirector.class, id);
		
		return director;
	}
	
	@Override
	public IDirector save(IDirector director) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(director);
		
		return director;
	}
}
