package com.codingdojo.dojos_and_ninjas.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.dojos_and_ninjas.mvc.models.Dojo;
import com.codingdojo.dojos_and_ninjas.mvc.models.Ninja;
import com.codingdojo.dojos_and_ninjas.mvc.repositories.NinjaRepository;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> getAll() {
        return ninjaRepository.findAll();
    }

    public List<Ninja> getAllByDojo(Dojo dojo) {
        return ninjaRepository.findAllByDojo(dojo);
    }

    public Ninja create(Ninja n) {
        return ninjaRepository.save(n);
    }

    public Ninja update (Ninja n) {
        return ninjaRepository.save(n);
    }

    public void delete(Ninja n) {
        ninjaRepository.delete(n);
    }

    public void delete(Long id) {
        ninjaRepository.deleteById(id);
    }

    public Ninja get(Long id) {
        Optional<Ninja> n = ninjaRepository.findById(id);
        if (n.isPresent()) {
            return n.get();
        }
        return null;
    }
}
