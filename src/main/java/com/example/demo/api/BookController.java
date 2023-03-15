package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/library")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping(path = "/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/search/{title}")
    public Book getBookByTitle(@PathVariable("title") String title) {
        return bookService.getBookByTitle(title)
                .orElse(null);
    }

    @DeleteMapping(path = "/delete/{title}")
    public void deleteBookByTitle(@PathVariable("title") String title) {
        bookService.deleteBook(title);
    }

    @PutMapping(path = "/update/{title}")
    public void updateBook(@PathVariable String title, @RequestBody String author) {
        bookService.updateBookAuthor(title, author);
    }
}
