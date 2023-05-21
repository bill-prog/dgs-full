package com.digitalgamestore.dgsbe.dtos;

import com.digitalgamestore.dgsbe.model.Uloga;

import java.io.Serializable;

public class UlogaDto implements Serializable {

    private Integer idUloga;
    private String nazivUloga;

    public UlogaDto(Uloga uloga) {
        this.idUloga = uloga.getId();
        this.nazivUloga = uloga.getNazivUloga();
    }

    public UlogaDto() {

    }

    public Integer getIdUloga() {
        return idUloga;
    }

    public void setIdUloga(Integer idUloga) {
        this.idUloga = idUloga;
    }

    public String getNazivUloga() {
        return nazivUloga;
    }

    public void setNazivUloga(String nazivUloga) {
        this.nazivUloga = nazivUloga;
    }
}
