package com.training.dao;

import java.util.function.Predicate;

import com.training.entity.Book;

public class StreamsExample {
	public static void main(String args[]) {
		BookService service = new BookService();
		
		// example of filter intermediate operation
		System.out.println("Greater than 500");
		service.findBookGrtThan(500).forEach(System.out::println);
		System.out.println("Less than 500");
		service.findBookByCondition(e->e.getPrice()<500).forEach(System.out::println);
		
//		example of map intermediate function
		service.getAllBookNames().forEach(System.out::println);
		
//		collective usage of map and filter intermediate operations
		service.getBookNamesGrtThan(500).forEach(System.out::println);
	
	}
}
