package com.limt.Models;

import com.limt.Lib.Utils;

import java.util.Date;

public class Book {
    private final Integer bookId;
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private Date yearOfPublication;
    private Integer numberOfPages;
    private Integer quantity;
    private String imagePath;

    public Book(String ISBN, String title, String author, String publisher, Date yearOfPublication, Integer numberOfPages, Integer quantity, String imagePath) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.bookId = Utils.generateBookID();
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }
    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
