package com.ex;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;

import com.ex.model.Book;

/**
 * RESTful Web Service Client
 * 
 * @author TJ
 */
public class MainClass {
	
	private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName()); //Optional - log request & response
	
	public static void main(String[] args) {
		
		/*
		 * Set up
		 */
		Client client = ClientBuilder.newClient();
		client.register(new LoggingFilter(LOGGER,true)); //Optional - log request & response
		WebTarget webTarget = client.target("http://localhost:8085/JerseyService/rest/library/book");
		
		/*
		 * Configure request
		 */
		Builder getBookBuilder = webTarget.path("1").request();
		Response getBookResponse = getBookBuilder
										.accept(MediaType.APPLICATION_JSON)
										.get(); //Send GET request
		
		/*
		 * Get status
		 */
//		int getBookStatus = getBookResponse.getStatus();
//		System.out.println(getBookStatus);
		
		/*
		 * Get response entity
		 */
		Book book = getBookResponse.readEntity(Book.class);
		System.out.println(book);
		
		/*
		 * ***************************************************************
		 */
		
		Builder getAllBooksBuilder = webTarget.request();
		Response getAllBooksReponse = getAllBooksBuilder
										.accept(MediaType.APPLICATION_JSON)
										.get();
		
		List<Book> bookList = getAllBooksReponse.readEntity(new GenericType<List<Book>>() {});
		for(Book temp : bookList){
			System.out.println(temp);
		}
		
		/*
		 * ***************************************************************
		 */
		
		Book newBook = new Book("The Art of Readable Code", "Dustin Boswell,Trevor Foucher", 2011);
		
		Builder addBookBuilder = webTarget.request();
		Response addBookResponse = addBookBuilder
										.post(Entity.entity(newBook, MediaType.APPLICATION_JSON));
		System.out.println(addBookResponse.readEntity(String.class));
	}
}
