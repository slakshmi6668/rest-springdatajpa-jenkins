package org.dxc.book.controller;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;

import org.dxc.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/findall")
	public List<Book> findAllBooks() {
		return (List<Book>) bookService.getAllBooks();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public HttpStatus insertBook(@RequestBody Book book) {
		boolean status = bookService.saveNewBook(book);
		return status ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	
	@RequestMapping("/findbyid")
	public Optional<Book> findById(@RequestParam("bookId") int bookId) {
		Optional<Book> result = bookService.getById(bookId);
		return result;
	}
	
	@RequestMapping("/findbyauthor")
	public List<Book> findByAuthor(@RequestParam("authorName") String authorName) {
		return (List<Book>) bookService.findByAuthorName(authorName);
		
	}
	
	@RequestMapping("/findbypublisher")
	public List<Book> findByPublisher(@RequestParam("publisher") String publisher) {
		return (List<Book>) bookService.findByPublisher(publisher);
		
	}
	@RequestMapping("/findbycategory")
	public List<Book> findByCategory(@RequestParam("category") String category) {
		return (List<Book>) bookService.findByCategory(category);
		
	}
	@DeleteMapping("/delete")
	public void deleteBook(@RequestParam("bookId")int bookId) {
		bookService.deleteById(bookId);
	}
	@RequestMapping(value="/updatebook/{id}",method=RequestMethod.PUT)
	public void update(@PathVariable("id")int bookId,@RequestBody Book book) {
		bookService.update(book,bookId);
	}
}
