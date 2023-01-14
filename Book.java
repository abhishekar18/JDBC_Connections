package com.training.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book>{

    private int BookId;
    private String bookName;
    private String author;
    private double price;
    private LocalDate dateOfPublications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return BookId == book.BookId && Double.compare(book.price, price) == 0 && Objects.equals(bookName, book.bookName) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BookId, bookName, author, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
    
    

    public Book(int bookId, String bookName, String author, double price, LocalDate dateOfPublications) {
		super();
		BookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.dateOfPublications = dateOfPublications;
	}

	public Book(int bookId, String bookName, String author, double price) {
        BookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

    public LocalDate getDateOfPublications() {
		return dateOfPublications;
	}

	public void setDateOfPublications(LocalDate dateOfPublications) {
		this.dateOfPublications = dateOfPublications;
	}

	@Override
    public int compareTo(Book otherobj) {
        return this.bookName.compareTo(otherobj.bookName);
    }
}