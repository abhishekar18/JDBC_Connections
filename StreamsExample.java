package com.training.dao;

import java.util.LinkedList;
import java.util.ListIterator;

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

//		using toMap static method
		service.getBookNameAndPrice().forEach((key,value)-> System.out.println(key+"\t "+value));	
		
//		using max function
		System.out.println(service.findMaxPrice());
		
//		using min function
		System.out.println(service.findMinPrice());
//		
//		System.out.println(service.totalBookPublishedPerYear(2006));
		
		
		LinkedList<Book> dbList = service.transformtoLinkedList();
		ListIterator<Book> itr = dbList.listIterator();
		while(itr.hasNext())
				System.out.println(itr.next().getBookName());
		while(itr.hasPrevious())
				System.out.println(itr.previous().getBookName());
		
		
	}
}
