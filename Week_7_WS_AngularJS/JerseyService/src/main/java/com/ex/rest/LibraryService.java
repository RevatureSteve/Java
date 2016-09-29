package com.ex.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import com.ex.model.Book;

/**
 * RESTful Web Service
 * 
 * @author TJ
 */
@Path(value="library")
public class LibraryService {
	
	@GET
	@Path("book/{bookId}")
	@Produces(value={"application/json","application/xml"})
	public Response getBook(@PathParam("bookId") String bookId){
		
		if(bookId.equals("1")){
			System.out.println("Success");
			Book book = new Book("Test Title", "Test Author", 1999);
			return Response.status(Response.Status.OK).entity(book).build();
		}else{
			System.out.println("Failure");
			return Response.status(418).entity("Failed to get something").build();
		}
	}
	
	@GET
	@Path("book")
	@Produces(value={"application/xml","application/json"})
	public Response getAllBooks(){
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("The Catcher in the Rye", "JD Salinger", 1951));
		bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
		bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
		
		/*
		 * Need for XML
		 */
		GenericEntity<List<Book>> parent = new GenericEntity<List<Book>>(bookList) {};
		
		return Response.status(Response.Status.OK).entity(parent).build();
	}
	
	@POST
	@Path("book")
	@Consumes(value={"application/json"})
	public Response addBook(Book book){
		System.out.println(book);
		String responseStr = "Book with title: " + book.getTitle() + " was saved successfully.";
		return Response.status(Response.Status.OK).entity(responseStr).build();
	}
	
}
