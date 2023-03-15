package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

//this interface laying out the operation that can be effectuated with our data
public interface BookDao {

    //insert book
    int insertBook(String title, String author);

    //get all book
    List<Book> selectAllBooks();

    //delete a book
    int deleteBook(String title);

    //search a book
    Optional<Book> searchBookByTitle(String title);

    //update the author
    int updateAuthor(String title, String author);
}
