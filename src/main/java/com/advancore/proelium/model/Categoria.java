package com.advancore.proelium.model;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categorias")
public class Categoria {
    @Id
    private Long id_categoria;
    private String nombre_categoria;

    @OneToMany(mappedBy = "categoria")
    private List<Entradas_categoria> entradaCategoria = new ArrayList<>();
}
