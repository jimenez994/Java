package com.zeus.mySqlConnection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zeus.mySqlConnection.models.Book;
import com.zeus.mySqlConnection.repositories.BookRepository;

//...
@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // update a book
 public Book updateBook(Long id,String title,String desc,String lang,int numOfPages) {
	 Book updatingBook = findBook(id);
	 if(updatingBook != null) {
		 updatingBook.setTitle(title);
		 updatingBook.setDescription(desc);
		 updatingBook.setId(id);
		 updatingBook.setLanguage(lang);
		 updatingBook.setNumberOfPages(numOfPages);
	 }else {
		 updatingBook = new Book(title,desc,lang,numOfPages);
	 }
     return bookRepository.save(updatingBook);
 }
 
 // delete a book
 public void deleteBook(Long id) {
     bookRepository.deleteById(id);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
}