package com.example.persona.repositories;

import com.example.persona.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    // Metodos de Querys
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    // Metodos de Pageable
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido , Pageable pageable);

    //boolean existsByDni (int dni);

    // JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    List<Persona> search(String filtro);

    // JPQL Pageable
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    Page<Persona> search(String filtro , Pageable pageable);

    // Query nativa
    @Query(
            value = "SELECT * FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNative(@Param("filtro")String filtro);

    // Query nativa
    @Query(
            value = "SELECT * FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNative(@Param("filtro")String filtro, Pageable pageable);


}
