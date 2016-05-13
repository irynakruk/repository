package com.rest.web.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
public class BookService {
	
	private static Map<Long, Book> books = new HashMap<>();
	
	public Book getBook(Long id){
		return books.get(id);
	}
	
	public Collection<Book> getAllBooks(){
		return books.values();
	}
	
	public void createBook(Long id, String name, String author){
		Book book = new Book(id, name, author);
		books.put(id, book);
	}
	
	public void updateBook(Long id, String name, String author){
		Book book = books.get(id);
		book.setAuthor(author);
		book.setName(name);
		books.replace(id, book);
	}
	
	public void removeBook(Long id){
		books.remove(id);
	}
}
