package com.training.dao;

public class StreamsExample {
	public static void main(String args[]) {
		BookService service = new BookService();
		service.findBookGrtThan(500).forEach(System.out::println);
	}
}
