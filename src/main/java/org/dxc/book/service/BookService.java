package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;

public interface BookService {	



	public List<Book> getAllBooks();
	public boolean saveNewBook(Book book);
	public Optional<Book> getById(int bookId);
	public List<Book> findByAuthorName(String authorName);
	public List<Book> findByPublisher(String publisher);
	public List<Book> findByCategory(String category);
	public void deleteById(int bookId);
	
	void update(Book book, int bookId);
	


	
	
}
