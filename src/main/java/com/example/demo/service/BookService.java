package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("data") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(Book book) {
        return bookDao.insertBook(book.getTitle(), book.getAuthor());
    }

    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookDao.searchBookByTitle(title);
    }

    public int deleteBook(String title) {
        return bookDao.deleteBook(title);
    }

    public int updateBookAuthor(String title, String author) {
        return bookDao.updateAuthor(title, author);
    }
}
