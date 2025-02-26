package com.learning.SpringBootApp.PayLoad;

import jakarta.validation.constraints.NotEmpty;

public class BookDto {
	@NotEmpty(message="book name should have some value")
    private String bookName;
    
	@NotEmpty(message="author name should not be empty")
    private String authorName;
   
    private double bookPrice;

	public BookDto() {
		super();
		
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
    
    
}


