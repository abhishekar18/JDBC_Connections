package com.training.dao;

import java.util.*;
import java.util.function.Predicate;

import com.training.entity.Book;

import static java.util.stream.Collectors.*;		//static import

public class BookService {

	private Collection<Book> list;

	public BookService() {
		super();
		BookRepoImpl dao = new BookRepoImpl();
		list= dao.findAll();	
	}
	// Using Intermediate Operation with filter() and Predicate 
	
	public List<Book> findBookGrtThan(double value){
		return this.list.stream().filter(e->e.getPrice()>value).collect(toList());
	}
	
	public List<Book> findBookByCondition(Predicate<Book> condition){
		return this.list.stream().filter(condition).collect(toList());
	}
}
