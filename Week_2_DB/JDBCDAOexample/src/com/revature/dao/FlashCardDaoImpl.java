package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.FlashCard;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class FlashCardDaoImpl implements DAO {

	@Override
	public void createFlashCard(FlashCard flashCard) {
		// Place connection in try with resources ()
		// Statement CreateFlashcard
		try (Connection connect = ConnectionUtil.getConnection();) {
			String q = "Hello?";
			String a = "World";

			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES('" + q + "', '" + a + "')";
			Statement statement = connect.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);

			System.out.println("Num of Rows affected: " + numRowsAffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createFlashCardPreparedStatement(FlashCard flashCard) {
		//Preparedstatement
		try (Connection connect = ConnectionUtil.getConnection();){

			//Set autoCommit to false
			connect.setAutoCommit(false); 
			
			//Add primaryKey String Array to our prepared statement
			String[] primaryKeys = new String[1];
			primaryKeys[0] = "fc_id";
			String sql = "INSERT INTO flash_cards(fc_question,fc_answer) VALUES(?,?)";
			PreparedStatement ps = connect.prepareStatement(sql, primaryKeys);
			ps.setString(1, flashCard.getQuestion());
			ps.setString(2, flashCard.getAnswer());
			
			//By default will auto commit, must set to false
			//When trying to run a transaction - multiple sql statement
			// where you want all or nothing!
			int numRowsAffected = ps.executeUpdate(); 
			
			System.out.println("Num of Rows affected - PreparedStatement: " + numRowsAffected);
			
			ResultSet generatedKeys = ps.getGeneratedKeys();
			
			System.out.println("Generated Keys: ");
			while(generatedKeys.next()){
				System.out.println(generatedKeys.getInt(1)); //column number
			}
			
			//With auto commit set to false
			connect.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<FlashCard> retrieveAllFlashCards() {
		
		List<FlashCard> fcList = new ArrayList<>();
			try (Connection connect = ConnectionUtil.getConnection();) {
				
				String getFCbyStoredProc = "{call get_all_fc_procedure(?)}";
				
				CallableStatement cs = connect.prepareCall(getFCbyStoredProc);
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				
				int numRow = cs.executeUpdate();
				System.out.println(numRow + " effected");
				
				ResultSet rs = (ResultSet) cs.getObject(1);
				while(rs.next()){
					fcList.add(new FlashCard(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return fcList;
	}

	@Override
	public int updateFlashCard(FlashCard flashCard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFlashCard(FlashCard flashCard) {
		// TODO Auto-generated method stub
		return 0;
	}

}
