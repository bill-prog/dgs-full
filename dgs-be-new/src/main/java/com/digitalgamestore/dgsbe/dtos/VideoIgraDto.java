package com.digitalgamestore.dgsbe.dtos;

import com.digitalgamestore.dgsbe.model.VideoIgra;

import java.io.Serializable;

public class VideoIgraDto implements Serializable {

    private Integer idVideoigra;
    private String nazivVideoigre;
    private Double cijenaVideoigre;
    private String nazivKategorija;
    private Integer idKategorija;
    private MinHardverDto minHardver;
    private Integer idMinHardver;
    private String nazivProizvodac;
    private Integer idProizvodac;

    public VideoIgraDto(VideoIgra videoigra) {
        this.idVideoigra = videoigra.getId();
        this.nazivVideoigre = videoigra.getNazivVideoigre();
        this.cijenaVideoigre = videoigra.getCijenaVideoigre();
        this.nazivKategorija = videoigra.getKategorija().getNazivKategorije();
        this.idKategorija = videoigra.getKategorija().getId();

        this.minHardver = new MinHardverDto(videoigra.getMinHardver());
        this.idMinHardver = videoigra.getMinHardver().getId();

        this.nazivProizvodac = videoigra.getProizvodac().getNazivProizvodac();
        this.idProizvodac = videoigra.getProizvodac().getId();
    }

    public VideoIgraDto() {

    }

    public Integer getIdVideoigra() {
        return idVideoigra;
    }

    public void setIdVideoigra(Integer idVideoigra) {
        this.idVideoigra = idVideoigra;
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


    public String getNazivKategorija() {
        return nazivKategorija;
    }

    public void setNazivKategorija(String nazivKategorija) {
        this.nazivKategorija = nazivKategorija;
    }

    public MinHardverDto getMinHardver() {
        return minHardver;
    }

    public void setMinHardver(MinHardverDto minHardver) {
        this.minHardver = minHardver;
    }

    public String getNazivProizvodac() {
        return nazivProizvodac;
    }

    public void setNazivProizvodac(String nazivProizvodac) {
        this.nazivProizvodac = nazivProizvodac;
    }

    public Integer getIdKategorija() {
        return idKategorija;
    }

    public void setIdKategorija(Integer idKategorija) {
        this.idKategorija = idKategorija;
    }

    public Integer getIdMinHardver() {
        return idMinHardver;
    }

    public void setIdMinHardver(Integer idMinHardver) {
        this.idMinHardver = idMinHardver;
    }

    public Integer getIdProizvodac() {
        return idProizvodac;
    }

    public void setIdProizvodac(Integer idProizvodac) {
        this.idProizvodac = idProizvodac;
    }
}