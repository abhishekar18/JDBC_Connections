package com.training.dao;

import java.util.function.Predicate;

import com.training.entity.Book;

public class StreamsExample {
	public static void main(String args[]) {
		BookService service = new BookService();
		service.findBookGrtThan(500).forEach(System.out::println);
		System.out.println("Less than 500");
		service.findBookByCondition(e->e.getPrice()<500).forEach(System.out::println);
	}
}
