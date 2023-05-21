package com.digitalgamestore.dgsbe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "uloga")
public class Uloga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduloga", nullable = false)
    private Integer id;

    @Column(name = "nazivuloga", nullable = false, length = 30)
    private String nazivUloga;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivUloga() {
        return nazivUloga;
    }

    public void setNazivUloga(String nazivUloga) {
        this.nazivUloga = nazivUloga;
    }
}
