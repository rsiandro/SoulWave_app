package com.soulwave.soulwaveapp.models;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    @Getter @Setter @Column(name = "id_art")
    private int id_art;

    @Getter @Setter @Column(name = "id_modelo")
    private int id_modelo;

    @Getter @Setter @Column(name = "en_stock")
    private boolean en_stock;

    @Getter @Setter @Column(name = "modif")
    private LocalDateTime modif;

}
