package com.revature.app;

import java.sql.DriverManager;

import com.revature.beans.HelloBean;
import com.revature.database.HelloDAO;

public class DataService {

	public void saveHelloBean(HelloBean model) {
		System.err.println("[LOG] Calling Business logic component");
				/*				// connect to a database
		Connection conn = DriverManager.getConnection(..);
					// open a transaction
					// call 3-5 DAO methods
		
		new GoodbyeDAO(conn).doWork();
					// commit/rollback transaction
					// DONE*/
		//new HelloDAO(conn).insert(model);
	}

}
