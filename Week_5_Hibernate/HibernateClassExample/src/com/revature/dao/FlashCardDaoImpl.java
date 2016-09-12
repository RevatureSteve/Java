package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.FlashCard;
import com.revature.util.ConnectionUtil;

public class FlashCardDaoImpl implements FlashCardDao{

	
	@Override
	public void createFC(FlashCard fc) {

		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = session.beginTransaction();

			session.save(fc);

			tx.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public FlashCard retrieveFCById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlashCard> retrieveAllFC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFC(FlashCard fc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFCById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
