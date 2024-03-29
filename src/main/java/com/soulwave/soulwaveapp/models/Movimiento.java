package com.soulwave.soulwaveapp.models;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento")
public class Movimiento {

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

    @Getter @Setter @Column (name = "id_modelo")
    private Integer id_modelo;

    @Getter @Setter @Column(name = "id_pro")
    private Integer id_pro;

    @Getter @Setter @Column(name = "id_fac")
    private String id_fac;

    @Getter @Setter @Column(name = "id_rem")
    private String id_rem;

    @Getter @Setter @Column(name = "id_ped")
    private String id_ped;

    @Getter @Setter @Column(name = "id_dev")
    private String id_dev;

    @Getter @Setter @Column(name = "valor")
    private Integer valor;

    @Getter @Setter @Column(name = "id_med")
    private Integer id_med;

    @Getter @Setter @Column(name = "ruta_cpbte")
    private String ruta_cpbte;

    }
