package com.digitalgamestore.dgsbe.model;

import jakarta.persistence.*;


@Entity
@Table(name = "kategorija")
public class Kategorija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkategorija")
    private Integer id;

    @Column(name = "opiskategorije", nullable = false, length = 500)
    private String opisKategorije;

    @Column(name = "nazivkategorije", nullable = false, length = 30)
    private String nazivKategorije;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idadmin", nullable = false)
    private Korisnik admin;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Korisnik getAdmin() {
        return admin;
    }

    public void setAdmin(Korisnik admin) {
        this.admin = admin;
    }
}
