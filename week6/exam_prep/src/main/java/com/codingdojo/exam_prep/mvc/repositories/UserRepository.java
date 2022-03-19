package com.codingdojo.exam_prep.mvc.repositories;

import java.util.Optional;

import com.codingdojo.exam_prep.mvc.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    public Optional<User> findByEmail(String email);
}
