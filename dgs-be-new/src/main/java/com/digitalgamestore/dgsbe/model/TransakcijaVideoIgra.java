package com.digitalgamestore.dgsbe.model;

import com.digitalgamestore.dgsbe.model.Transakcija;
import jakarta.persistence.*;

@Entity
@Table(name = "transakcijavideoigra")
public class TransakcijaVideoIgra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransakcijavideoigra", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="idtransakcije", nullable=false)
    private Transakcija transakcija;

    @ManyToOne
    @JoinColumn(name="idvideoigra", nullable=false)
    private VideoIgra videoIgra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transakcija getTransakcija() {
        return transakcija;
    }

    public void setTransakcija(Transakcija transakcija) {
        this.transakcija = transakcija;
    }

    public VideoIgra getVideoIgra() {
        return videoIgra;
    }

    public void setVideoIgra(VideoIgra videoIgra) {
        this.videoIgra = videoIgra;
    }

}
