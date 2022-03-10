package com.codingdojo.dojos_and_ninjas.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.dojos_and_ninjas.mvc.models.Dojo;
import com.codingdojo.dojos_and_ninjas.mvc.repositories.DojoRepository;

import org.springframework.stereotype.Service;

@Service
public class DojoService {
    
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> getAll() {
        return dojoRepository.findAll();
    }

    public Dojo create(Dojo d) {
        return dojoRepository.save(d);
    }

    public Dojo update(Dojo d) {
        return dojoRepository.save(d);
    }

    public void delete(Dojo d) {
        dojoRepository.delete(d);
    }

    public void delete(Long id) {
        dojoRepository.deleteById(id);
    }

    public Dojo get(Long id) {
        Optional<Dojo> d = dojoRepository.findById(id);
        if (d.isPresent()) {
            return d.get();
        }

        return null;
    }
}
