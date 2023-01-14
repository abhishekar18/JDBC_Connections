package com.training.utils;

import com.training.dao.BookRepoImpl;
import com.training.entity.Book;
import com.training.utils.DbConnections;

import java.time.LocalDate;
import java.util.*;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        System.out.println(DbConnections.getMySqlConnection());

        int key=1;
        BookRepoImpl repo= new BookRepoImpl();

        switch (key){
            case 1:
                System.out.println("Is Added:="+repo.save(new Book(101,"Head First Java", "Kathy Sierra",450,(LocalDate.of(2006,01,02)))));
                System.out.println("Is Added:="+repo.save(new Book(102,"Thinking Java", "Erra",1450,(LocalDate.of(2006,01,02)))));
                System.out.println("Is Added:="+repo.save(new Book(103,"Java", "Sierra",325,(LocalDate.of(2006,01,02)))));
                System.out.println("Is Added:="+repo.save(new Book(104,"Head First Java", "Kathy Sierra",450,(LocalDate.of(2006,01,02)))));
                break;
            case 2:
            	Collection<Book> list = repo.findAll();
    			list.forEach(System.out::println);
    			break;

            case 3:
                Optional<Book> found= repo.findById(102);
                if(found.isPresent()) {
                	System.out.println(found.get());
                }
                else
                    System.out.println("Element Not Found");
            case 4:
            	int result= repo.removeById(104);
            	if(result==1)
            		System.out.println("Element Deleted");
            	else
            		System.out.println("Element Not Found");
            	
            default:
                break;
        }
    }
}