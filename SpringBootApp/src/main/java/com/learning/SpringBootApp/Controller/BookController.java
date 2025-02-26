package com.learning.SpringBootApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.SpringBootApp.PayLoad.ApiResponse;
import com.learning.SpringBootApp.PayLoad.BookDto;
import com.learning.SpringBootApp.Service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookDto bookDto){
		BookDto dto = this.bookService.createBook(bookDto);
		return new ResponseEntity<BookDto>(dto,HttpStatus.CREATED);		
	}
	@GetMapping("/{bookId}")
	public ResponseEntity<BookDto> getBookById(@PathVariable int bookId){
		BookDto bookById = this.bookService.getBookById(bookId);
		return new ResponseEntity<BookDto>(bookById,HttpStatus.FOUND);
		
	}
	@GetMapping("/book")
	public ResponseEntity<List<BookDto>> getBook(){
		List<BookDto> books = this.bookService.getBooks();
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	@PutMapping("/{bookId}")
	public ResponseEntity<BookDto> updateBook(@PathVariable int bookId,@Valid @RequestBody BookDto bookDto){
		BookDto updatedBook = this.bookService.updateBook(bookId, bookDto);
		return new ResponseEntity<>(updatedBook,HttpStatus.OK);
		
	}
	@DeleteMapping("/{bookId}")
	public ResponseEntity<ApiResponse>deleteBook(@PathVariable int bookId){
		this.bookService.deleteBook(bookId);
		ApiResponse response = new ApiResponse("Book deleted successfully",true);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
// http://localhost:8080/api/v1/book