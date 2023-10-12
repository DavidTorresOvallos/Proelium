package com.advancore.proelium.model;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
    private String correo;
    private String contraseña;

    @OneToMany(mappedBy = "usuario")
    private List<Entrada> entradas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios = new ArrayList<>();
}
