package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository("data")
public class BookDataAccesService implements BookDao {

    private static List<Book> DB = new ArrayList<>();

    //this method adds a new book in database, if the book doesn't exist
    @Override
    public int insertBook(String title, String author) {
        Book book = new Book(title, author);    //create a new Book instance with the values send as parameters
        if(DB.contains(book)) {     //if this book already exist in our database
            return 0;           //return 0
        }
        DB.add(book);      //add the book in database
        return 1;       //return 1
    }

    //this method gets all books from the library
    @Override
    public List<Book> selectAllBooks() {
        return DB
                .stream()       //make a stream
                .sorted(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle))        //sort the books by author, and then by title
                .toList();
    }

    //this method deletes a book(if exist) from our library
    @Override
    public int deleteBook(String title) {
        Optional<Book> bookMaybe = searchBookByTitle(title);        //check if the book exists in our database
        if(bookMaybe.isEmpty()) {      //in case we can't find the book
            return 0;       //return 0...
        }
        DB.remove(bookMaybe.get());         //delete from database
        return 1;       //return 1.....
    }

    //this method searches for a book in our library
    @Override
    public Optional<Book> searchBookByTitle(String title) {
        return DB
                .stream()           //make a stream
                .filter(book -> book.getTitle().equals(title))      //filter books
                .findFirst();       //return the first book that has the title we are searching for
    }

    //this method updates the author
    @Override
    public int updateAuthor(String title, String author) {
        return searchBookByTitle(title)     //first step: searching the book
                .map(b -> {
                    int indexOfBookToUpdate = DB.indexOf(b);        //get the index from our database(ArrayList)
                    if(indexOfBookToUpdate >= 0) {          //if the index is valid
                        DB.get(indexOfBookToUpdate).setAuthor(author);      //update author
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);     //if we don't find the book
    }
}
