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
@Table(name = "venta")
@Immutable
public class Venta {

    @Id
    @Getter @Setter @Column(name = "id_mov")
    private int id_mov;

    @Getter @Setter @Column(name = "fechayhora")
    private LocalDateTime fechayhora;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "tipo")
    private String tipo;

    @Getter @Setter @Column(name = "id_usr")
    private int id_usr;

    @Getter @Setter @Column(name = "id_cliente")
    private int id_cliente;

    @Getter @Setter @Column(name = "id_art")
    private int id_art;

    @Getter @Setter @Column(name = "id_modelo")
    private Integer id_modelo;

    @Getter @Setter @Column(name = "id_pro")
    private Integer id_pro;

    @Getter @Setter @Column(name = "id_fac")
    private String id_fac;

    @Getter @Setter @Column(name = "id_rem")
    private Integer id_rem;

    @Getter @Setter @Column(name = "id_ped")
    private Integer id_ped;

    @Getter @Setter @Column(name = "id_dev")
    private Integer id_dev;

    @Getter @Setter @Column(name = "valor")
    private Integer valor;

    @Getter @Setter @Column(name = "id_med")
    private Integer id_med;

    @Getter @Setter @Column(name = "ruta_cpbte")
    private String ruta_cpbte;

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
