package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.IActor;

@Repository
public class ActorRepository implements IActorRepository {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<IActor> findAll() {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<IActor> actors = s.createCriteria(IActor.class).list();
		
		return actors;
	}
	
	@Override
	public IActor findOne(int id) {
		Session s = sf.getCurrentSession();
		
		IActor actor = (IActor) s.get(IActor.class, id);
		
		return actor;
	}
	
	@Override
	public IActor save(IActor actor) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(actor);
		
		return actor;
	}
}