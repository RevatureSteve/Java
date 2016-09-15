package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import static org.hibernate.criterion.Restrictions.*;

import com.ex.dao.util.ConnectionUtil;
import com.ex.domain.BankUser;

public class DaoImpl {

	public BankUser getUserById(Integer id) {

		Session session = ConnectionUtil.getSession();

		BankUser user = (BankUser) session.get(BankUser.class, id);

		session.close();

		return user;
	}

	public BankUser getUserByUsername(String username) {
		BankUser user = null;
		
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(BankUser.class);
		criteria.add(eq("username", username));
		List<BankUser> users = criteria.list();
		if(users.size() == 1){
			user = users.get(0);
		}

		session.close();

		return user;
	}

}
