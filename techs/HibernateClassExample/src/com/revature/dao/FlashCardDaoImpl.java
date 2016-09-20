package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.FlashCard;
import com.revature.util.ConnectionUtil;

public class FlashCardDaoImpl implements FlashCardDao {

	@Override
	public void createFC(FlashCard fc) {

		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = session.beginTransaction();

			session.save(fc); // Create/Insert

			tx.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public FlashCard retrieveFCById(Integer id) {

		Session session = ConnectionUtil.getSession();

		FlashCard fc = null;
		try {
			fc = (FlashCard) session.get(FlashCard.class, id);
			System.out.println(fc);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlashCard> retrieveAllFC() {
		Session session = ConnectionUtil.getSession();
		
		//READ ONLY! Used to add restrictions
		Criteria criteria = session.createCriteria(FlashCard.class);
		
		List<FlashCard> fcList = criteria.list();
		
		session.close();
		
		return fcList;

		
	}

	@Override
	public void updateFC(FlashCard fc) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = session.beginTransaction();

			session.update(fc);

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteFCById(Integer id) {
		
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			
			session.delete(new FlashCard(id,null,null));
			
			tx.commit();
		}finally{
			session.close();
		}

	}

}
