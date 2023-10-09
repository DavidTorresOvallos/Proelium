package com.advancore.proelium.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entradas")
public class Entrada {
    @Id
    private Long id_entrada;
    private String titulo;
    private String contenido;
    private Date fecha_publicacion;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "entrada")
    private List<Entradas_categoria> entradasCategorias = new ArrayList<>();

    @OneToMany(mappedBy = "entrada")
    private List<Comentarios> comentarios = new ArrayList<>();
}
