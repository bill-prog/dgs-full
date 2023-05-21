package com.digitalgamestore.dgsbe.dtos;

import com.digitalgamestore.dgsbe.model.Kategorija;

import java.io.Serializable;

public class KategorijaDto implements Serializable {

    private Integer idKategorija;
    private String opisKategorije;
    private String nazivKategorije;
    private Integer idAdmin;

    private String nazivAdmin;

    public KategorijaDto(Kategorija kategorija) {
        this.idKategorija = kategorija.getId();
        this.opisKategorije = kategorija.getOpisKategorije();
        this.nazivKategorije = kategorija.getNazivKategorije();
        this.idAdmin = kategorija.getAdmin().getId();
        this.nazivAdmin = kategorija.getAdmin().getKorisnickoIme();
    }

    public KategorijaDto() {
    }


    public Integer getIdKategorija() {
        return idKategorija;
    }

    public void setIdKategorija(Integer idKategorija) {
        this.idKategorija = idKategorija;
    }

    public String getOpisKategorije() {
        return opisKategorije;
    }

    public void setOpisKategorije(String opisKategorije) {
        this.opisKategorije = opisKategorije;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    public void setNazivKategorije(String nazivKategorije) {
        this.nazivKategorije = nazivKategorije;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNazivAdmin() {
        return nazivAdmin;
    }

    public void setNazivAdmin(String nazivAdmin) {
        this.nazivAdmin = nazivAdmin;
    }
}
