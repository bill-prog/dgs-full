package com.digitalgamestore.dgsbe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "osvrt")
public class Osvrt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idosvrt", nullable = false)
    private Integer id;

    @Column(name = "ocjena", nullable = false)
    private Double ocjena;

    @Column(name = "komentar", nullable = false, length = 500)
    private String komentar;

    @ManyToOne
    @JoinColumn(name = "idvideoigra", nullable = false)
    private VideoIgra videoIgra;

    @ManyToOne
    @JoinColumn(name = "idkorisnik", nullable = false)
    private Korisnik korisnik;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOcjena() {
        return ocjena;
    }

    public void setOcjena(Double ocjena) {
        this.ocjena = ocjena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public VideoIgra getVideoIgra() {
        return videoIgra;
    }

    public void setVideoIgra(VideoIgra videoIgra) {
        this.videoIgra = videoIgra;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
