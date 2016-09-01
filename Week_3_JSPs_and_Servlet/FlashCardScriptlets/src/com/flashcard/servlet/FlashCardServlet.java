package com.flashcard.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flashcard.service.FlashCardService;

public class FlashCardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FlashCardService fcService = new FlashCardService();
		
		req.setAttribute("currentFlashCard", fcService.getRandomFlashCard());
		
		RequestDispatcher rd = req.getRequestDispatcher("flashCard.jsp");
		rd.forward(req, resp);
		
	}
	
}
