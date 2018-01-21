package com.zeus.books.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.books.models.Book;
import com.zeus.books.repositories.BookRepository;

@Service
public class BookService {
	 private BookRepository bookRepository;
	 public BookService(BookRepository bookRepository){
		 this.bookRepository = bookRepository;
	 }
	
	 public ArrayList<Book> allBooks(){
       return (ArrayList<Book>) bookRepository.findAll();
	 }
	 
	 public void addBook(Book book){
	   bookRepository.save(book);
	 }
	 public void destroyBook(Long id) {
	    bookRepository.delete(id);
	 }
	 public Book findBookById(Long id) {
	    return bookRepository.findOne(id);
	 }
	 public void updateBook(Book book) {
	    bookRepository.save(book);
	 }
}
