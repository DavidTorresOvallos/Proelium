package com.advancore.proelium.model;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Entrada")
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrada;
    private String titulo;
    private String contenido;
    private Date fecha_publicacion;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;
    
    @OneToMany(mappedBy = "entrada")
    private List<Comentario> comentario = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "entrada_categoría", joinColumns = @JoinColumn(name = "entrada_id", referencedColumnName = "id_entrada"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    )
    private List<Categoria> categoria;
}
