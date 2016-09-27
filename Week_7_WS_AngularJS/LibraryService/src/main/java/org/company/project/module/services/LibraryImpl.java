
package org.company.project.module.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.company.project.module.exception.LibraryFullException;
import org.company.project.module.model.Book;

@WebService(endpointInterface = "org.company.project.module.services.Library")
public class LibraryImpl implements Library {

	@Override
	public List<Book> getAllBooks() {
		System.out.println("getAllBooks");
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("The Catcher in the Rye", "JD Salinger", 1951));
		bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
		bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
		return bookList;
	}

	@Override
	public String addBook(Book book) throws LibraryFullException {
		System.out.println("******Service:addBook: " + book);
		if(book.getYear() > 1999){
			throw new LibraryFullException("Library full. Cannot add book: "+book);
		}
		return "Successfully added book with title: " + book.getTitle();
	}

}

