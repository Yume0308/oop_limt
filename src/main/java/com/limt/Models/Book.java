package com.limt.Models;

import javafx.scene.control.CheckBox;

public class Book {
    private final CheckBox checkBox;
    private String ID;
    private String ISBN;
    private String Title;
    private String Author;
    private String Category;
    private String Publisher;
    private Integer Quantity;
    private Integer Remaining;
    private String imagePath;

    public Book(String ID, String ISBN, String title, String author, String category, String publisher, Integer quantity, Integer remainingBooks, String imagePath) {
        checkBox = new CheckBox();
        this.ID = ID;
        this.ISBN = ISBN;
        Title = title;
        Author = author;
        Category = category;
        Publisher = publisher;
        Quantity = quantity;
        Remaining = remainingBooks;
        this.imagePath = imagePath;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public String getID() {
        return ID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getCategory() {
        return Category;
    }

    public String getPublisher() {
        return Publisher;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public Integer getRemaining() {
        return Remaining;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public void setRemaining(Integer remaining) {
        Remaining = remaining;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
