package com.revature.main;


import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;

public class MainClass {

	public static void main(String[] args) {
	
		
	//	FlashCard fc = new FlashCard("Hello DAO with Debug?","FlashCardDaoImpl Debug" );
		
		DAO dao = new FlashCardDaoImpl();
		
	//	dao.createFlashCardPreparedStatement(fc);
		
		List<FlashCard> fcMainList = dao.retrieveAllFlashCards();
		
		for(FlashCard fcElement : fcMainList){
			System.out.println(fcElement);
		}
		
//		//Callable Statement - Stored Procedured
//		try (Connection connect = ConnectionUtil.getConnection();){
//			String q = "Hello CallableStatement?";
//			String a = "World CallableStatement";
//			String err = "";
//			
//			//Must wrap in {} or you won't get data back but it'll still go through
//			String sql = "{call insert_fc_procedure(?,?,?) }"; 
//			
//			CallableStatement cs = connect.prepareCall(sql);
//			cs.setString(1, q);
//			cs.setString(2, a);
//			cs.setString(3, err);
//			
//			int status = cs.executeUpdate();
//			
//			System.out.println(" CallableStatement returns: " + status);
//			System.out.println("Error message: " + err);
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
	}

}
