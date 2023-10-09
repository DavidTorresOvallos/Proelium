package com.advancore.proelium.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

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
