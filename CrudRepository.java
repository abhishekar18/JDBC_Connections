package com.training.ifaces;

import java.util.Collection;
import java.util.Optional;

public interface CrudRepository<T> {
	
	public boolean save(T t);
	public Optional findById(long key);
	public Collection<T> findAll();
	public int removeById(long key);

}
