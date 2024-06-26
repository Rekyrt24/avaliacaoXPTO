package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livros;
import com.example.demo.services.LivrosService;

@RestController
@RequestMapping("/livro")
@CrossOrigin(origins = "http://localhost:8080")
public class LivrosController {
    private final LivrosService livrosService;

    @Autowired
    public LivrosController(LivrosService livrosService) {
        this.livrosService = livrosService;
    }

    @PostMapping
    public Livros createLivros(@RequestBody Livros livros) {
        return livrosService.saveLivros(livros);
    }

    @GetMapping("/{id}")
    public Livros getLivros(@PathVariable Long id) {
        return livrosService.getLivrosById(id);
    }

    @GetMapping
    public List<Livros> getAllLivros() {
        return livrosService.getAllLivros();
    }

    @DeleteMapping("/{id}")
    public void deleteLivros(@PathVariable Long id) {
    	livrosService.deleteLivros(id);
    }
    
}