package com.learning.SpringBootApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.SpringBootApp.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
