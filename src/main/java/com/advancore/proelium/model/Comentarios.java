package com.advancore.proelium.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@Table(name = "Comentarios")
public class Comentarios {
    @Id
    private Long id_comentario;
    private String comentario;
    private Date fecha_comentario;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_entrada", nullable = false)
    private Entrada entrada;
}
