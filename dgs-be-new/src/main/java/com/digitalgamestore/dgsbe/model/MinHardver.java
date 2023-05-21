package com.digitalgamestore.dgsbe.model;

import jakarta.persistence.*;


@Entity
@Table(name = "minhardver")
public class MinHardver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idminhardver", nullable = false)
    private Integer id;

    @Column(name = "procesor", nullable = false, length = 30)
    private String procesor;

    @Column(name = "grafičkakartica", nullable = false, length = 30)
    private String grafickaKartica;

    @Column(name = "ram", nullable = false, length = 30)
    private String ram;

    @Column(name = "disk", nullable = false, length = 30)
    private String disk;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
}
