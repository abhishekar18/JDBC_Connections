package com.training.dao;

import com.training.entity.Book;
import com.training.ifaces.CrudRepository;
import com.training.utils.DbConnections;

import java.sql.*;
import java.util.*;
public class BookRepoImpl implements CrudRepository<Book> {
    private Connection con;

    public BookRepoImpl() {
        super();
        this.con= DbConnections.getMySqlConnection();
    }

    public BookRepoImpl(Connection con) {
        super();
        this.con = con;
    }
    public void close(){
        try{
            this.con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
/**
 * @param The method takes the entity as the parameter
 * @return it returns a boolean value, if the row is added then it returns true else it returns false
 */

    @Override
    public boolean save(Book t) {
        int rowAdded=1;
        String sql="insert into bajaj_book value(?,?,?,?)"; //placeholder
        try(PreparedStatement pstmt = this.con.prepareStatement(sql)){
            pstmt.setInt(1,t.getBookId());
            pstmt.setString(2, t.getBookName());
            pstmt.setString(3,t.getAuthor());
            pstmt.setDouble(4,t.getPrice());

            rowAdded = pstmt.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return rowAdded==1?true:false;
    }

    @Override
    public Optional<Book> findById(long key) {
    	String sql="select * from bajaj_book where bookId=?";
    	Optional<Book> found = Optional.empty();
    	try (PreparedStatement pstmt = con.prepareStatement(sql)){
    		pstmt.setLong(1, key);
    		ResultSet rs = pstmt.executeQuery();
    		while(rs.next()) {
    			int bookId = rs.getInt("bookId");
                String bookName=rs.getString("bookName");
                String author=rs.getString("author");
                double price=rs.getDouble("price");
                
                Book book=new Book(bookId,bookName,author,price);
                found = Optional.of(book);
    		}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return found;
    }

    @Override
    public Collection<Book> findAll() {
        String sql="select * from bajaj_book";
        Set<Book> list=new TreeSet<>();
        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                int bookId = rs.getInt("booKId");
                String bookName=rs.getString("bookName");
                String author=rs.getString("author");
                double price=rs.getDouble("price");

                Book book=new Book(bookId,bookName,author,price);

                list.add(book);

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int removeById(long key) {
    	String sql="delete from bajaj_book where bookId=?";
    	int rowsDeleted=0;
    	try (PreparedStatement pstmt = con.prepareStatement(sql)){
    		pstmt.setLong(1, key);
    		rowsDeleted = pstmt.executeUpdate();
 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        return rowsDeleted;
    }
}