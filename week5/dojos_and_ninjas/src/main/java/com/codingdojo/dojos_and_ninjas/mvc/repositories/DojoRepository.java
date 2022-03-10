package com.codingdojo.dojos_and_ninjas.mvc.repositories;

import java.util.List;

import com.codingdojo.dojos_and_ninjas.mvc.models.Dojo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
    
    public List<Dojo> findAll();
}
