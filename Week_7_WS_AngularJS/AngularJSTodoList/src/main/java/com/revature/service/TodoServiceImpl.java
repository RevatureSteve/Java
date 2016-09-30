package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.TodoDao;
import com.revature.dto.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoDao todoDao;
	
	@Transactional
	@Override
	public void save(Todo todo) {
		todoDao.save(todo);		
	}

}
