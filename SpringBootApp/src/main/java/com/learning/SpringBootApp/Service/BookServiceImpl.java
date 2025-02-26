package com.learning.SpringBootApp.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.SpringBootApp.Entity.Book;
import com.learning.SpringBootApp.Exception.ResourceNotFoundException;
import com.learning.SpringBootApp.PayLoad.BookDto;
import com.learning.SpringBootApp.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private ModelMapper mapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = this.mapper.map(bookDto, Book.class);
        Book savedBook = this.bookRepository.save(book);
        return this.mapper.map(savedBook, BookDto.class);
    }

    @Override
    public BookDto getBookById(int bookId) {
        Book book = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "bookId", bookId));
        return this.mapper.map(book, BookDto.class);
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> all = this.bookRepository.findAll();
        return all.stream()
                .map(book -> this.mapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(int bookId, BookDto bookDto) {
        Book book = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "bookId", bookId));
        
        book.setBookName(bookDto.getBookName());
        book.setAuthorName(bookDto.getAuthorName());
        book.setBookPrice(bookDto.getBookPrice());
        
        Book updatedBook = this.bookRepository.save(book);
        return this.mapper.map(updatedBook, BookDto.class);
    }

    @Override
    public void deleteBook(int bookId) {
        Book book = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "bookId", bookId));
        this.bookRepository.delete(book);
    }
}
