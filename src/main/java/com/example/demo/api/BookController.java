package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/library")
@RestController
public class BookController {

    //fields
    private final BookService bookService;

    //constructor
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //this endpoint adds a new book
    @PostMapping(path = "/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    //this endpoint returns all book from our (fake) database
    @GetMapping(path = "/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //this endpoint search a book in our (fake) database
    @GetMapping(path = "/search/{title}")
    public Book getBookByTitle(@PathVariable("title") String title) {
        return bookService.getBookByTitle(title)
                .orElse(null);
    }

    //this endpoint deletes a book from our (fake) database
    @DeleteMapping(path = "/delete/{title}")
    public void deleteBookByTitle(@PathVariable("title") String title) {
        bookService.deleteBook(title);
    }

    //this endpoint update the author if we find the book in our (fake) database
    @PutMapping(path = "/update/{title}")
    public void updateBook(@PathVariable String title, @RequestBody String author) {
        bookService.updateBookAuthor(title, author);
    }
}
