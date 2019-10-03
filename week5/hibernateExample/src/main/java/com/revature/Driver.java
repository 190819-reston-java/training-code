package com.revature;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Driver {
	
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder ssrb;
	private static SessionFactory sf;
	private static Session session;
	
	public static void main(String[] args) {
		/*
		 * This is boilerplate config, provided your configuration is is
		 * a hibernate.cfg.xml file in resources.
		 */
		configuration = new Configuration().configure();
		ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sf = configuration.buildSessionFactory(ssrb.build());
		
		//firstDemo();
		
		//secondDemo();
		
		//thirdDemo();
		
		fourthDemo();
		
		//fifthDemo();
		
		sf.close();
		
	}
	
	private static void fifthDemo() {
		session = sf.openSession();
		session.beginTransaction();
		
		Criteria c = session.createCriteria(Actor.class);
		
		System.out.println(c.list());
		
		System.out.println(c.add(Restrictions.gt("height", 5.5)).list());
		
		//here :var is like a ? in preparedstatement.
		Query q = session.createQuery("from Actor where height > :var and stageName = :var2");
		
		System.out.println(q.setDouble("var", 5.5).setString("var2", "Bond").list());
		
		session.getTransaction().commit();
		
	}

	private static void fourthDemo() {
		session = sf.openSession();
		session.beginTransaction();
		
		Movie wind = (Movie) session.get(Movie.class, 1L);
		
		System.out.println("Getting Wind:");
		System.out.println(wind);
		for(Actor a : wind.getActors()) {
			System.out.println(a);
			for(Movie m : a.getMovies()) {
				System.out.println(m);
			}
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void thirdDemo() {
		session = sf.openSession();
		session.beginTransaction();
		
		Movie oz = (Movie) session.get(Movie.class, 3L);
		
		System.out.println(oz.getDirector().getName());
		
		Director ozu = (Director) session.get(Director.class, 3L);
		System.out.println(ozu);
		
		Movie newMovie = new Movie();
		newMovie.setTitle("Test title");
		newMovie.setGenre("Mystery");
		newMovie.setDirector(ozu);
		
		session.saveOrUpdate(newMovie);
		
		session.getTransaction().commit();
		session.close();
		
	}

	private static void secondDemo() {
		session = sf.openSession();
		session.beginTransaction();
		
		Director newDirector = new Director();
		newDirector.setName("Franklin");
		
		session.save(newDirector);
		
		Movie newMovie = new Movie();
		newMovie.setTitle("Planet of the Apes");
		newMovie.setGenre("Action");
		
		session.save(newMovie);
		
		session.getTransaction().commit();
		session.close();
		
	}

	private static void firstDemo() {
		session = sf.openSession();
		session.beginTransaction();
		
		Actor newActor = new Actor();
		newActor.setName("Jim");
		newActor.setHeight(3);
		
		System.out.println(newActor);
		session.save(newActor);
		System.out.println(newActor);
		
		System.out.println("Getting Actor from DB");
		Actor fetchedActor = (Actor) session.get(Actor.class, 3L);
		System.out.println(fetchedActor);
		fetchedActor.setName("Adam");
		session.update(fetchedActor);
		
		/*
		 * Use Criteria to query the DB for records that meet conditions
		 * use Restrictions and Projections to restrict/aggregate
		 */
		Criteria tallWithStageName =  session.createCriteria(Actor.class)
				.add(Restrictions.isNotNull("stageName"))
				.add(Restrictions.gt("height", 4.0));
		
		List<Actor> actorsMeetingCriteria = tallWithStageName.list();
		System.out.println(actorsMeetingCriteria);
		
		Criteria countDistinctActorNames = session.createCriteria(Actor.class)
				.setProjection(Projections.countDistinct("name"));
		
		System.out.println(countDistinctActorNames.uniqueResult());
		
		session.getTransaction().commit();
		session.close();
	}

}
