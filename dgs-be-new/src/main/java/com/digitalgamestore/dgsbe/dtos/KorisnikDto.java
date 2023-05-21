package com.digitalgamestore.dgsbe.dtos;

import com.digitalgamestore.dgsbe.model.Korisnik;

import java.io.Serializable;

public class KorisnikDto implements Serializable {

    private Integer idKorisnik;
    private String emailAdresa;
    private String korisnickoIme;
    private Integer idUloga;
    private Integer idProizvodac;

    public KorisnikDto() {
    }
    public KorisnikDto(Korisnik korisnik) {
        this.idKorisnik = korisnik.getId();
        this.emailAdresa = korisnik.getEmailAdresa();
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.idUloga = korisnik.getUloga().getId();

        // Check if the proizvodac is not null
        if (korisnik.getProizvodac() != null) {
            this.idProizvodac = korisnik.getProizvodac().getId();
        }
    }


    public Integer getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Integer idKorisnik) {
        this.idKorisnik = idKorisnik;
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


    public Integer getIdUloga() {
        return idUloga;
    }

    public void setIdUloga(Integer idUloga) {
        this.idUloga = idUloga;
    }

    public Integer getIdProizvodac() {
        return idProizvodac;
    }

    public void setIdProizvodac(Integer idProizvodac) {
        this.idProizvodac = idProizvodac;
    }
}
