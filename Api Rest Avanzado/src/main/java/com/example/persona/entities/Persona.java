package com.example.persona.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Persona extends Base {

    private String nombre;
    private String apellido;
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "persona_libro",
            joinColumns = @JoinColumn(name ="persona_id"),
            inverseJoinColumns = @JoinColumn(name="libro_id")
    )
    private List<Libro> libros = new ArrayList<Libro>();
}
