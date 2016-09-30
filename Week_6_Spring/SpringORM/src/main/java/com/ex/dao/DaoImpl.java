package com.ex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ex.domain.FlashCard;

@Transactional
public class DaoImpl implements Dao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveFC(FlashCard fc) {
		Session session = sessionFactory.getCurrentSession();
		session.save(fc);
	}

	@Override
	public List<FlashCard> getAllFC() {
		
		List<FlashCard> fcList = sessionFactory.getCurrentSession().createCriteria(FlashCard.class).list(); 
		return fcList;
	}

	@Override
	public FlashCard getFlashCardById(Integer id) {
		FlashCard fc = (FlashCard) sessionFactory.getCurrentSession().get(FlashCard.class, id);
		return fc;
	}
	
	
}
