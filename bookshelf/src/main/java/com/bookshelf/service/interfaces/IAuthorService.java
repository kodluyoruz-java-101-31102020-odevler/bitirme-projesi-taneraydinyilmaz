package com.bookshelf.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookshelf.dao.model.Authors;

@Service
public interface IAuthorService {
 
	
	public Authors save(Authors authors);
	public void update(Authors authors);
	public void delete(Long authorId);
	public List<Authors> getAll();
	public List<Authors> findByAuthorName(String author);
	public Authors findByAuthorId(Long authorId);
	public List<Authors> searchBar(String keyword);
	
 
}
