package com.advancore.proelium.model;

import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    private Long id__usuario;
    private String nombre;
    private String correo;
    private String contraseña;

    @OneToMany(mappedBy = "usuario")
    private List<Entrada> entradas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Comentarios> comentarios = new ArrayList<>();
}
