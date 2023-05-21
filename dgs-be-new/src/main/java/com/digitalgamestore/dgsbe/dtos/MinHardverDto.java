package com.digitalgamestore.dgsbe.dtos;

import com.digitalgamestore.dgsbe.model.MinHardver;

import java.io.Serializable;

public class MinHardverDto implements Serializable {

    private Integer idMinhardver;
    private String procesor;
    private String grafickaKartica;
    private String ram;
    private String disk;

    public MinHardverDto(MinHardver minhardver) {
        this.idMinhardver = minhardver.getId();
        this.procesor = minhardver.getProcesor();
        this.grafickaKartica = minhardver.getGrafickaKartica();
        this.ram = minhardver.getRam();
        this.disk = minhardver.getDisk();
    }

    public MinHardverDto()
    {

    }

    public Integer getIdMinhardver() {
        return idMinhardver;
    }

    public void setIdMinhardver(Integer idMinhardver) {
        this.idMinhardver = idMinhardver;
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