package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private String title;
    private String author;

    public Book(@JsonProperty("title") String title, @JsonProperty("author") String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book) {
            return title.equals(((Book)obj).title) && author.equals(((Book)obj).getAuthor());
        }
        return false;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
