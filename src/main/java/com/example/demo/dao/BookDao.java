package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    int insertBook(String title, String author);

    List<Book> selectAllBooks();

    int deleteBook(String title);

    Optional<Book> searchBookByTitle(String title);

    int updateAuthor(String title, String author);
}
