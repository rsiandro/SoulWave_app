package com.soulwave.soulwaveapp.models;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @Getter @Setter @Column(name = "id_mod")
    private int id_mod;

    @Getter @Setter @Column(name = "categoria")
    private String categoria;

    @Getter @Setter @Column(name = "marca")
    private String marca;

    @Getter @Setter @Column(name = "modelo")
    private String modelo;

    @Getter @Setter @Column(name = "talle")
    private String talle;

    @Getter @Setter @Column(name = "color")
    private String color;

    @Getter @Setter @Column(name = "id_proveedor")
    private int id_proveedor;

    @Getter @Setter @Column(name = "precio_costo")
        private float precio_costo;

    @Getter @Setter @Column(name = "precio_contado")
    private float precio_contado;

    @Getter @Setter @Column(name = "precio_lista")
    private float precio_lista;

    @Getter @Setter @Column(name = "ruta_foto")
        private String ruta_foto;

    @Getter @Setter @Column(name = "link_web")
        private String link_web;

}
