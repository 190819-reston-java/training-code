package com.revature;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Driver {

	public static void main(String[] args) {
		/*
		 * This is boilerplate config, provided your configuration is is
		 * a hibernate.cfg.xml file in resources.
		 */
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(ssrb.build());
		
		Session session = sf.openSession();
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
		sf.close();
		
	}

}
