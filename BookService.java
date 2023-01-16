package com.training.dao;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		return this.list.stream().filter(condition.negate()).collect(toList());
	
	}
	
	public Set<String> getAllBookNames(){
		return this.list.stream().map(e->e.getBookName()).collect(toSet());
	}
	public List<String> getBookNamesGrtThan(double value){
		return this.list.stream()
						.filter(e->e.getPrice()>value)
						.map(e->e.getBookName())
						.collect(toList());
	}
	
	public Map<String, Double> getBookNameAndPrice(){
		return this.list.stream().collect(toMap(Book::getBookName, Book::getPrice));
	}
	public Double findMaxPrice() {
		return this.list.stream().filter(e->e.getPrice()>0).max(Comparator.comparing(Book::getPrice)).get().getPrice();
	}
	
	public Double findMinPrice() {
		return this.list.stream().filter(e->e.getPrice()>0).min(Comparator.comparing(Book::getPrice)).get().getPrice();
	}
	
	public int totalBookPublishedPerYear(int year) {
		return (int) this.list.stream().filter(e->e.getDateOfPublications().getYear()==year).count();
	}
	
	public LinkedList<Book> transformtoLinkedList(){
		return this.list.stream().collect(Collectors.toCollection(LinkedList::new));
	}
}
