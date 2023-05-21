package com.digitalgamestore.dgsbe.model;

import java.util.Date;
import jakarta.persistence.*;


@Entity
@Table(name = "proizvođač")
public class Proizvodac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproizvodac", nullable = false)
    private Integer id;

    @Column(name = "nazivproizvodac", nullable = false, length = 30)
    private String nazivProizvodac;

    @Column(name = "godosnutka", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date godOsnutka;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivProizvodac() {
        return nazivProizvodac;
    }

    public void setNazivProizvodac(String nazivProizvodac) {
        this.nazivProizvodac = nazivProizvodac;
    }

    public Date getGodOsnutka() {
        return godOsnutka;
    }

    public void setGodOsnutka(Date godOsnutka) {
        this.godOsnutka = godOsnutka;
    }
}
