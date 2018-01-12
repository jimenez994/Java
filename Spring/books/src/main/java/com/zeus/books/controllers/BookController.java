package com.zeus.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.books.models.Book;
import com.zeus.books.services.BookService;

@Controller
@RequestMapping("/")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("")
	public String books(Model model) {
		List<Book> books = bookService.allBooks();
    model.addAttribute("books", books);
    return "index.jsp";
    }
	@RequestMapping("/bla")
	public String bla(Model model) {
		List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "bla.jsp";
    }
	@RequestMapping("/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") int index) {
		 Book book = bookService.findBookByIndex(index);
	     model.addAttribute("book", book);
	     return "showBook.jsp";
    }
	@RequestMapping("/new")
	public String newBook(@ModelAttribute("book")Book book) {
		return "newBook.jsp";
	}

    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBook.jsp";
        }else{
            bookService.addBook(book);
            return "redirect:/";
        }
    }
    @RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
    		Book book = bookService.findBookByIndex(id);
    		if (book != null) {
    			model.addAttribute("book",book);
    			return "editBook.jsp";
    		}else {
    			return "redirect:/";
    		}
    }
    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
        		for(int i=0;i<result.getAllErrors().size();i++) {
        		}
            return "redirect:/books/edit/{id}";
        }else{
            bookService.updateBook(id, book);
            return "redirect:/";
        }
    }
    @RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") int id) {
        bookService.destroyBook(id);
        return "redirect:/";
    }


}
