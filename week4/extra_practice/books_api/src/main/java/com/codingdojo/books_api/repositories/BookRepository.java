package com.codingdojo.books_api.repositories;

import java.util.List;

import com.codingdojo.books_api.models.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    
    List<Book> findAll();

    List<Book> findByDescriptionContaining(String search_for);

    Long countByTitleContaining(String search_for);

    Long deleteByTitleStartingWith(String search_for);
}
