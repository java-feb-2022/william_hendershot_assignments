package com.codingdojo.book_club.mvc.repositories;

import java.util.Optional;

import com.codingdojo.book_club.mvc.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    public Optional<User> findByEmail(String email);
}
