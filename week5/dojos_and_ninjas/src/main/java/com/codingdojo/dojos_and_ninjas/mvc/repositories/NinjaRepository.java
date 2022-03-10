package com.codingdojo.dojos_and_ninjas.mvc.repositories;

import java.util.List;

import com.codingdojo.dojos_and_ninjas.mvc.models.Ninja;

import org.springframework.data.repository.CrudRepository;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    
    public List<Ninja> findAll();
}
