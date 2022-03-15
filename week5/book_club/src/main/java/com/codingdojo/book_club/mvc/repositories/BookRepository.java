package com.codingdojo.book_club.mvc.repositories;

import java.util.List;

import com.codingdojo.book_club.mvc.models.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    
    public List<Book> findAll();
}
