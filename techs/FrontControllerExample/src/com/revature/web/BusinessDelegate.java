package com.revature.web;

import com.revature.app.DataService;
import com.revature.beans.HelloBean;

public class BusinessDelegate {

	public void saveHelloBean(HelloBean model) {
		// delegate responsibility
		new DataService().saveHelloBean(model);
		// maybe more calls
	}

}
