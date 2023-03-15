package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    //fields
    private String title;
    private String author;

    //constructor
    public Book(@JsonProperty("title") String title, @JsonProperty("author") String author) {
        this.title = title;
        this.author = author;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    //this methods check for the value equality
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book) {
            return title.equals(((Book)obj).title) && author.equals(((Book)obj).getAuthor());
        }
        return false;
    }

    //setters
    public void setAuthor(String author) {
        this.author = author;
    }
}
