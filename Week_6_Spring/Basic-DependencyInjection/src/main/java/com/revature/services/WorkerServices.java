package com.revature.services;


import com.revature.dao.Dao;
import com.revature.model.Worker;

public class WorkerServices {

	private Dao edao ;
	
	public void setEdao(Dao edao) {
		this.edao = edao;
	}

	public Worker findEmployee(int id){
		return edao.findById(id);
	}

}
