package com.codingdojo.book_club.mvc.repositories;

import java.util.List;

import com.codingdojo.book_club.mvc.models.Book;
import com.codingdojo.book_club.mvc.models.BookThought;
import com.codingdojo.book_club.mvc.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookThoughtRepository extends CrudRepository<BookThought, Long> {
    
    public List<BookThought> findAllByBook(Book book);

    public List<BookThought> findAllByUser(User user);
}
