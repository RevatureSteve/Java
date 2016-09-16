package com.revature.hibernate.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.domain.Bears;
import com.revature.hibernate.domain.Cave;
import com.revature.hibernate.domain.HoneyPot;
import com.revature.hibernate.util.HibernateConnUtil;



public class BearDaoImpl implements BearDao{

	public void createBearsDemo() {
		Session session = HibernateConnUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		//Roaming Bears looking for a place to hibernate! zzz
		Bears parent = new Bears("black1","Black Bear", 100.00,2000.00,new HoneyPot(100,100));
		
		int i = (Integer) session.save(parent.getHoneyPot());
		System.out.println(i + " Parent Bear's ----------HoneyPot Generated ID");
		
		//Bear has little Cub
		Bears child = new Bears("brown1","Brown Bear",25,500,new HoneyPot(30,30));
			//Add child to Parent Bear's bearCub Collection
			parent.getBearCubs().add(child);
			//Save Child's Honeypot
			session.save(child.getHoneyPot());
		
		//They found a Cave!
		Cave newHome = new Cave(600,"warm cave");
		parent.setDwelling(newHome);
		child.setDwelling(newHome);
		
		session.save(newHome);
		session.save(parent);
		session.save(child);
		tx.commit();
		session.close();
		System.out.println("------TIME TO HIBERNATE---------");
		
	}

	public Bears getOrLoad(int id) {
		Session session = HibernateConnUtil.getSession();
		
		Bears bearGet = (Bears) session.get(Bears.class,id);
		System.out.println(bearGet.getClass() + " : loadBear");
//	s	System.out.println(bearGet.getBearColor());
		return bearGet;
	}

	@SuppressWarnings("unchecked")
	public void criteriaDemo() {

		Session session = HibernateConnUtil.getSession();
		
		Criteria criteria;
		
		System.out.println("---------List All Bears--------");
		
		List<Bears> bears = session.createCriteria(Bears.class).list();
		
		for(Bears bear : bears){
			System.out.println(bear);
		}
		
		System.out.println("--------Only Brown Bears---------");
		bears = session.createCriteria(Bears.class).add(Restrictions.ilike("bearColor", "brown")).list();
		for(Bears bear : bears){
			System.out.println(bear);
		}
		
		System.out.println("---------%------------");
		criteria = session.createCriteria(Bears.class)
				.add(	
						Restrictions.and(		
							Restrictions.ilike("bearColor","black"),
							Restrictions.isNotNull("breed"))
						);
			bears = criteria.list();
			for(Bears bear : bears){
				System.out.println(bear + ": bear");
			}
	}

	@SuppressWarnings("unchecked")
	public void queryDemo() {
		
		System.out.println("------Get Brown Bears---------");
		
		Session session = HibernateConnUtil.getSession();
		String hql = "FROM Bears AS b WHERE b.bearColor = :fur";
		Query query = session.createQuery(hql);
		query.setParameter("fur", "Brown");
		List<Bears> bears = query.list();
		
		for(Bears bear : bears){
			System.out.println(bear);
		}
		
		
		System.out.println("-------Feed a bear before it hibernates---------");
		
		
		String hql2 = "UPDATE Bears SET weight = weight + :fat WHERE bearId = :bearId";
		Bears bear150 = (Bears) session.get(Bears.class, 152);
		
		System.out.println("Before hibernating bear150 must eat! ");
		System.out.println("His/Her current weight: " + bear150.getWeight());
		
		Transaction tx = session.beginTransaction();
		query = session.createQuery(hql2);
		query.setDouble("fat", 500);
		query.setParameter("bearId", 150);
		int rowsUpdated = query.executeUpdate();
		
		tx.commit();
		System.out.println(rowsUpdated + " bears updated");
		System.out.println("------------HIBERNATED-----------");
	}
	
	
	
	public Bears getBearById(Integer id){
		return (Bears) HibernateConnUtil.getSession().get(Bears.class, id);
	}
	

}
