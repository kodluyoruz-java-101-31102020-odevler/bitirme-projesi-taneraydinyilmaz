package com.bookshelf.web.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookshelf.dao.model.Authors;
import com.bookshelf.service.AuthorService;

@Controller
public class AuthorPageController {

	@Autowired
	private AuthorService authorService; 
	
	
	@RequestMapping(value = "/author/list", method = RequestMethod.GET)
	public String getAuthor(Model model) {

		List<Authors> authors = authorService.getAll();
		model.addAttribute("authors", authors);
		System.err.println("toplam yazar sayısı "  + authors.size());

		return "author-list";
	}

	@RequestMapping(value = "/author/save", method = RequestMethod.GET)
	public String getEmployeeSavePage(Authors employeeContext) {
		
		return "author-save";
	}
	
	
	@RequestMapping(value = "/author/save", method = RequestMethod.POST)
    public String save(Authors authors, BindingResult result, Model model) {
          
		authorService.save(authors);
        
		model.addAttribute("employees", authorService.getAll());
        
        return "redirect:/author/list";
    }
	 
	@RequestMapping(value = "/author/search", method = RequestMethod.GET)
	public String viewSearchList(Model model, @Param("keyword") String keyword) {
		List<Authors> listAuthor = authorService.searchBar(keyword);
		model.addAttribute("listAuthor", listAuthor);
		model.addAttribute("keyword", keyword);
		return "author-search";
	}

//	@RequestMapping("/author/list")
//	public String save(Authors authors, BindingResult result, Model model) {
//		authorService.save(authors);
//		model.addAttribute("authors", authorService.getAll());
//		return "redirect:/author/list";
//
//	}

	@GetMapping("/author/list/{authorId}")
	public String deleteBook(@PathVariable(name = "authorId") Long authorId) {
		authorService.delete(authorId);
		authorService.getAll();
		return "redirect:/author/list";
	}
}
