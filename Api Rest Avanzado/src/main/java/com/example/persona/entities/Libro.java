package com.example.persona.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name ="libro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Libro extends Base {

    private int fecha;
    private String genero;
    private int paginas;
    private String titulo;


    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;

}
