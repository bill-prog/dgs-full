package com.digitalgamestore.dgsbe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "videoigra")
public class VideoIgra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvideoigra", nullable = false)
    private Integer id;

    @Column(name = "nazivvideoigre", nullable = false, length = 50)
    private String nazivVideoigre;

    @Column(name = "cijenavideoigre", nullable = false)
    private Double cijenaVideoigre;

    @ManyToOne
    @JoinColumn(name = "idkategorija", nullable = false)
    private Kategorija kategorija;

    @ManyToOne
    @JoinColumn(name = "idminhardver", nullable = false)
    private MinHardver minHardver;

    @ManyToOne
    @JoinColumn(name = "idproizvodac", nullable = false)
    private Proizvodac proizvodac;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivVideoigre() {
        return nazivVideoigre;
    }

    public void setNazivVideoigre(String nazivVideoigre) {
        this.nazivVideoigre = nazivVideoigre;
    }

    public Double getCijenaVideoigre() {
        return cijenaVideoigre;
    }

    public void setCijenaVideoigre(Double cijenaVideoigre) {
        this.cijenaVideoigre = cijenaVideoigre;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public MinHardver getMinHardver() {
        return minHardver;
    }

    public void setMinHardver(MinHardver minHardver) {
        this.minHardver = minHardver;
    }

    public Proizvodac getProizvodac() {
        return proizvodac;
    }

    public void setProizvodac(Proizvodac proizvodac) {
        this.proizvodac = proizvodac;
    }
}
