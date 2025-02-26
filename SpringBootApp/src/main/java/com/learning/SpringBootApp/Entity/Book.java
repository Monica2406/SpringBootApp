package com.learning.SpringBootApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id; // Match the column name in the database

    private String bookName;
    private String authorName;
    private double bookPrice;

    // Default Constructor
    public Book() {}

    // Getters and Setters
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    // toString() method for better debugging
    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}