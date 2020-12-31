package com.bookshelf.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.annotation.RuntimeAspect;
import com.bookshelf.dao.model.Authors;
import com.bookshelf.dao.reporsitory.AuthorRepository;
import com.bookshelf.service.interfaces.IAuthorService;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorRepository authorRepository;

 
	@Override
	@Transactional
	public Authors save(Authors authors) {
		return authorRepository.save(authors);
	}

 
	@Override
	@Transactional
	public void update(Authors authors) {
		authorRepository.save(authors);

	}

	@RuntimeAspect(active = true)
	@Override
	@Transactional
	public void delete(Long authorId) {
		if (authorRepository.findById(authorId)!=null)
			authorRepository.deleteById(authorId);

	}
	
	@RuntimeAspect(active = true)
	@Override
	public List<Authors> getAll() { 
		return authorRepository.getAllAuthors();
	}

	@Override
	public List<Authors> findByAuthorName(String authorName) { 
		return authorRepository.findByAuthor(authorName);
	}

	@Override
	public Authors findByAuthorId(Long authorId) { 
		return authorRepository.findByAuthorId(authorId);
	}

	@RuntimeAspect(active = true)
	@Override
	public List<Authors> searchBar(String keyword) { 
		if(keyword!=null) {
			return authorRepository.findByAuthor(keyword);
		}
		return authorRepository.getAllAuthors();
	}

// 

}
