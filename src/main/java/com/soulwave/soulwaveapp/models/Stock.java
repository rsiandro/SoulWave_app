package com.soulwave.soulwaveapp.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@Immutable
public class Stock {

    @Id
    @Getter @Setter @Column(name = "id_art")
    private int id_art;

    @Getter @Setter @Column(name = "id_modelo")
    private int id_modelo;

    @Getter @Setter @Column(name = "en_stock")
    private int en_stock;

    @Getter @Setter @Column(name = "modif")
    private LocalDateTime modif;

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
