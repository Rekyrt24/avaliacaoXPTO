package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	@Query(value = "SELECT * FROM Autor l WHERE lower(l.pais) LIKE %:pais%", nativeQuery = true)
	List<Autor> buscarPorPais(@Param("pais") String pais);
	
	@Query ("SELECT l FROM Autor l WHERE l.autor = ?1")
	List<Autor> findByAutor(String autor);
	
}
