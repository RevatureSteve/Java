package com.revature.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		//Required for Connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "flash_card_db";
		String password = "p4ssw0rd";
		
		//Place connection in try with resources ()
//		try (Connection connect = DriverManager.getConnection(url, username, password);) {
//			String q = "Hello?";
//			String a = "World";
//			
//			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES('" + q + "', '" + a + "')";
//			Statement statement = connect.createStatement();
//			int numRowsAffected = statement.executeUpdate(sql);
//			
//			System.out.println("Num of Rows affected: " + numRowsAffected);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		//Preparedstatement
		
		
//		try (Connection connect =  DriverManager.getConnection(url, username, password);){
//			String q = "Hello Preparedstatemnet?2";
//			String a = "World Preparedstatement";
//
//			//Add primaryKey String Array to our prepared statement
//			String[] primaryKeys = new String[1];
//			primaryKeys[0] = "fc_id";
//			
//			String sql = "INSERT INTO flash_cards(fc_question,fc_answer) VALUES(?,?)";
//			PreparedStatement ps = connect.prepareStatement(sql, primaryKeys);
//			ps.setString(1, q);
//			ps.setString(2, a);
//			
//			int numRowsAffected = ps.executeUpdate();
//			
//			System.out.println("Num of Rows affected - PreparedStatement: " + numRowsAffected);
//			
//			ResultSet generatedKeys = ps.getGeneratedKeys();
//			
//			System.out.println("Generated Keys: ");
//			while(generatedKeys.next()){
//				System.out.println(generatedKeys.getInt(1)); //column number
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//Callable Statement - Stored Procedured
		try (Connection connect = DriverManager.getConnection(url, username, password);){
			String q = "Hello CallableStatement?";
			String a = "World CallableStatement";
			String err = "";
			
			//Must wrap in {} or you won't get data back but it'll still go through
			String sql = "{call insert_fc_procedure(?,?,?) }"; 
			
			CallableStatement cs = connect.prepareCall(sql);
			cs.setString(1, q);
			cs.setString(2, a);
			cs.setString(3, err);
			
			int status = cs.executeUpdate();
			
			System.out.println(" CallableStatement returns: " + status);
			System.out.println("Error message: " + err);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
