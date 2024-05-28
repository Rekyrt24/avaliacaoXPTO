package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livros;
import com.example.demo.repositories.LivrosRepository;

@Service
public class LivrosService {
    private final LivrosRepository livrosRepository;

    @Autowired
    public LivrosService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public Livros saveLivros(Livros livros) {
        return livrosRepository.save(livros);
    }

    public Livros getLivrosById(Long id) {
        return livrosRepository.findById(id).orElse(null);
    }

    public List<Livros> getAllLivros() {
        return livrosRepository.findAll();
    }

    public void deleteLivros(Long id) {
    	livrosRepository.deleteById(id);
    }
    
}
