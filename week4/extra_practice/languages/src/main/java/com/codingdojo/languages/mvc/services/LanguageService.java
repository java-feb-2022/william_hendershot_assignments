package com.codingdojo.languages.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.languages.mvc.models.Language;
import com.codingdojo.languages.mvc.repositories.LanguageRepository;

import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    public Language create(Language l) {
        return languageRepository.save(l);
    }

    public Language update(Language l) {
        return languageRepository.save(l);
    }

    public void delete(Language l) {
        languageRepository.delete(l);
    }

    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

    public Language get(Long id) {
        Optional<Language> l = languageRepository.findById(id);
        if (l.isPresent()) {
            return l.get();
        }
        return null;
    }
}
