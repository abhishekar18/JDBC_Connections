package com.training.dao;

import java.util.*;
import java.util.stream.*;

import com.training.entity.Book;

import java.util.function.*;

import static java.util.stream.Collectors.*;		//static import

public class BookService {

	private Collection<Book> list;

	public BookService() {
		super();
		// TODO Auto-generated constructor stub
		BookRepoImpl dao = new BookRepoImpl();
		list= dao.findAll();	
	}
	// Using Intermediate Operation with filter() and Predicate 
	
	public List<Book> findBookGrtThan(double value){
		return this.list.stream().filter(e->e.getPrice()>value).collect(toList());
	}
	
}
