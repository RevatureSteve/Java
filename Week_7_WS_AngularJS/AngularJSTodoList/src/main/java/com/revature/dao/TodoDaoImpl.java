package com.revature.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.dto.Todo;

@Repository
public class TodoDaoImpl implements TodoDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(Todo todo) {
		sessionFactory.getCurrentSession().save(todo);
		
	}

}
