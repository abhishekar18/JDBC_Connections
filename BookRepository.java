package com.training.ifaces;

public interface BookRepository<T> extends CrudRepository<T> {
	public T findByAuthor(String author);
	
}
