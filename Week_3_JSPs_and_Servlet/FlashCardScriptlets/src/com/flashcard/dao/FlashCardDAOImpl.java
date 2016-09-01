package com.flashcard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flashcard.domain.FlashCard;
import com.flashcard.util.ConnectionUtil;

public class FlashCardDAOImpl implements FlashCardDAO {

	@Override
	public List<FlashCard> retrieveAllFlashCards() {
		
		List<FlashCard> flashCards = new ArrayList<>();

		String sql = "select fc_id, fc_question, fc_answer from flash_cards";
		
		try(Connection conn = ConnectionUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			ResultSet rs = pstmt.executeQuery(); //Will be closed automatically when Statement is closed (if ResultSet is still open)
			
			while(rs.next()){
				int id = rs.getInt("fc_id");
				String question = rs.getString("fc_question");
				String answer = rs.getString("fc_answer");
				FlashCard tempFlashCard = new FlashCard(id, question, answer);
				flashCards.add(tempFlashCard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flashCards;
	}
	
	
}
