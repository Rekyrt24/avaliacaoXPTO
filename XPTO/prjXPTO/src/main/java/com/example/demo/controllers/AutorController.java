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

import com.example.demo.entities.Autor;
import com.example.demo.services.AutorService;

@RestController
@RequestMapping("/autor")
@CrossOrigin(origins = "http://localhost:8080")
public class AutorController {
    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.saveAutor(autor);
    }

    @GetMapping("/{id}")
    public Autor getAutor(@PathVariable Long id) {
        return autorService.getAutorById(id);
    }

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Long id) {
    	autorService.deleteAutores(id);
    }
    @GetMapping("/pais/{pais}")
    public List<Autor> buscarPorPais(@PathVariable String pais) {
    	return autorService.buscarPorPais(pais);
    }
    @GetMapping("/autor/{autor}")
    public List<Autor> buscarPorAutor(@PathVariable String autor) {
    	return autorService.buscarPorAutor(autor);
    }
    
}

