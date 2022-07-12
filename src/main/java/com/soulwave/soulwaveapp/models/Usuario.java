package com.soulwave.soulwaveapp.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Getter @Setter @Column(name = "id_usr")
        private int id_usr;

    @Getter @Setter @Column(name = "nombreusr")
        private String nombreusr;

    @Getter @Setter @Column(name = "contrasena")
        private String contrasena;

    @Getter @Setter @Column(name = "nombre")
        private String nombre;

    @Getter @Setter @Column(name = "apellido")
        private String apellido;

    @Getter @Setter @Column(name = "email")
        private String email;

    @Getter @Setter @Column(name = "telefono")
        private String telefono;

    @Getter @Setter @Column(name = "legajo")
        private int legajo;

    @Getter @Setter @Column(name = "id_rol")
        private int id_rol;

    }
