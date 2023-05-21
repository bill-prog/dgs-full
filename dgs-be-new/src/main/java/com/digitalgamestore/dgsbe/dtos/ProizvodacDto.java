package com.digitalgamestore.dgsbe.dtos;

import com.digitalgamestore.dgsbe.model.Proizvodac;

import java.io.Serializable;
import java.util.Date;

public class ProizvodacDto implements Serializable {

    private Integer idProizvodac;
    private String nazivProizvodac;
    private Date godOsnutka;

    public ProizvodacDto(Proizvodac proizvodac) {
        this.idProizvodac = proizvodac.getId();
        this.nazivProizvodac = proizvodac.getNazivProizvodac();
        this.godOsnutka = proizvodac.getGodOsnutka();
    }

    public ProizvodacDto() {

    }

    public Integer getIdProizvodac() {
        return idProizvodac;
    }

    public void setIdProizvodac(Integer idProizvodac) {
        this.idProizvodac = idProizvodac;
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