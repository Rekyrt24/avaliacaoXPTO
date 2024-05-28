package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Autor;
import com.example.demo.repositories.AutorRepository;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public void deleteAutores(Long id) {
    	autorRepository.deleteById(id);
    }
    public List<Autor> buscarPorPais(String pais) {
    	return autorRepository.buscarPorPais(pais);
    }
    public List<Autor> buscarPorAutor(String autor) {
    	return autorRepository.findByAutor(autor);
    }
   
}