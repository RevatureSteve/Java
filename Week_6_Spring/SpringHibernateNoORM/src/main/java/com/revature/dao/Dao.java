package com.revature.dao;

import com.revature.model.BankUser;

public interface Dao {

		public BankUser getBankUserByUsername(String bankUsername);
}
