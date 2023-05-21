package com.digitalgamestore.dgsbe.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transakcija")
public class Transakcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransakcije", nullable = false)
    private Integer id;

    @Column(name = "datumtransakcije", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datumTransakcije;

    @Column(name = "ukupaniznos", nullable = false)
    private Double ukupanIznos;

    @ManyToOne
    @JoinColumn(name="idkorisnik", nullable=false)
    private Korisnik korisnik;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatumTransakcije() {
        return datumTransakcije;
    }

    public void setDatumTransakcije(Date datumTransakcije) {
        this.datumTransakcije = datumTransakcije;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
