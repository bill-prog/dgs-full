package com.digitalgamestore.dgsbe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkorisnik", nullable = false)
    private Integer id;

    @Column(name = "emailadresa", nullable = false, length = 30, unique = true)
    private String emailAdresa;

    @Column(name = "korisnickoime", nullable = false, length = 30, unique = true)
    private String korisnickoIme;

    @Column(name = "lozinka", nullable = false)
    private Integer lozinka;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduloga", nullable = false)
    private Uloga uloga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproizvodac")
    private Proizvodac proizvodac;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Integer getLozinka() {
        return lozinka;
    }

    public void setLozinka(Integer lozinka) {
        this.lozinka = lozinka;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Proizvodac getProizvodac() {
        return proizvodac;
    }

    public void setProizvodac(Proizvodac proizvodac) {
        this.proizvodac = proizvodac;
    }
}


