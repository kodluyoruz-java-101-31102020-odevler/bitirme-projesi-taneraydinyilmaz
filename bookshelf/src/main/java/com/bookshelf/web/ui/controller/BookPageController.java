package com.bookshelf.web.ui.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookshelf.dao.model.Authors;
import com.bookshelf.dao.model.Book;
import com.bookshelf.service.AuthorService;
import com.bookshelf.service.BookService;

@Controller
public class BookPageController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBook(Model model) {

		List<Book> book = bookService.getAll();
		model.addAttribute("book", book);

		System.err.println("toplam kitap sayısı " +book.size()); 

		return "book-list";
	}

	@RequestMapping(value = "/book/save", method = RequestMethod.GET)
	public String getBookSavePage(Book book, Model model) {  
		List<Authors> authors = authorService.getAll(); 
		model.addAttribute("authors", authors);
		return "book-save"; 
	}

	@RequestMapping(value = "book/search", method = RequestMethod.GET)
	public String viewSearchList(Model model, @Param("keyword") String keyword) {
		List<Book> listBook = bookService.searchBar(keyword);
		model.addAttribute("listBook", listBook);
		model.addAttribute("keyword", keyword);
		return "book-search";
	}

	@RequestMapping("/book/list")
	public String save(Book book, BindingResult result, Model model) {
		bookService.save(book);
		model.addAttribute("books", bookService.getAll());
		return "redirect:/book/list";

	}

	@GetMapping("/book/list/{bookId}")
	public String deleteBook(@PathVariable(name = "bookId") Long bookId) {
		bookService.delete(bookId);
		bookService.getAll();
		return "redirect:/book/list";
	}

	 
//	@PostMapping("/book/update/{id}")
//	public String update(@PathVariable("bookId") Long bookId, @Valid Book book, 
//	  BindingResult result, Model model) {
//	     	
//	    	book.setBookId(bookId); 
//	        return "book-update";
//	     
//	    bookService.save(book);
//	    return "book-list";
//		}

 

	
}
