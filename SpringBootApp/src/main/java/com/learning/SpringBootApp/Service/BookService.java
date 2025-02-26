package com.learning.SpringBootApp.Service;



import java.util.List;

import com.learning.SpringBootApp.PayLoad.BookDto;

public interface BookService {
	BookDto createBook(BookDto bookDto);
	BookDto getBookById(int bookId);
	List<BookDto> getBooks();
	BookDto updateBook(int bookId,BookDto bookDto);
	void deleteBook(int bookId);
}
