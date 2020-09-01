package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public boolean saveNewBook(Book book) {
		boolean status = bookRepository.save(book) != null;
		return  status;
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> b = bookRepository.findAll();
		return b;
	}
	

	public Optional<Book> getById(int bookId) {		
		Optional<Book>result=bookRepository.findById(bookId);
		return result;
	}
	@Override
	public List<Book> findByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		List<Book> c = bookRepository.findByAuthorName(authorName);
		return c;
	}
	@Override
	public List<Book> findByPublisher(String publisher) {
		// TODO Auto-generated method stub
		List<Book> d = bookRepository.findByPublisher(publisher);
		return d;
		
	}
	@Override
	public List<Book> findByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> e = bookRepository.findByCategory(category);
		return e;
		
	}

	@Override
	public void deleteById(int bookId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(bookId);
	}

	@Override
	public void update(Book book, int bookId) {
		// TODO Auto-generated method stub
		Book updatedBook=bookRepository.getOne(bookId);
		updatedBook.setBookName(book.getBookName());
		updatedBook.setAuthorName(book.getAuthorName());
		updatedBook.setPublisher(book.getPublisher());
		updatedBook.setIsbn(book.getIsbn());
		updatedBook.setCategory(book.getCategory());
		updatedBook.setPrice(book.getPrice());
		bookRepository.save(updatedBook);
	}

	
	
}
