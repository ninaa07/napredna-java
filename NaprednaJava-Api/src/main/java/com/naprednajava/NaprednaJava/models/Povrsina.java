package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naprednajava.NaprednaJava.models.Enums.Status;

import javax.validation.constraints.NotBlank;

public class Povrsina {

    @NotBlank
    private Integer id;

    @NotBlank
    private Integer oznaka;

    @NotBlank
    private String naziv;

    @NotBlank
    private String vrstaPoda;

    @NotBlank
    private String prostorijaNaziv;

    @NotBlank
    private Status status;

    @NotBlank
    private Integer vrstaPovrsineId;

    @NotBlank
    private Integer projekatZaGradjevinskuDozvoluId;

    public Povrsina(@JsonProperty("id") Integer id, @JsonProperty("oznaka") Integer oznaka, @JsonProperty("naziv") String naziv, @JsonProperty("vrstaPoda") String vrstaPoda, @JsonProperty("prostorijaNaziv") String prostorijaNaziv, @JsonProperty("status") Status status, @JsonProperty("vrstaPovrsineId") Integer vrstaPovrsineId, @JsonProperty("projekatZaGradjevinskuDozvoluId") Integer projekatZaGradjevinskuDozvoluId) {
        this.id = id;
        this.oznaka = oznaka;
        this.naziv = naziv;
        this.vrstaPoda = vrstaPoda;
        this.prostorijaNaziv = prostorijaNaziv;
        this.status = status;
        this.vrstaPovrsineId = vrstaPovrsineId;
        this.projekatZaGradjevinskuDozvoluId = projekatZaGradjevinskuDozvoluId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOznaka() {
        return oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getVrstaPoda() {
        return vrstaPoda;
    }

    public String getProstorijaNaziv() {
        return prostorijaNaziv;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getVrstaPovrsineId() {
        return vrstaPovrsineId;
    }

    public Integer getProjekatZaGradjevinskuDozvoluId() {
        return projekatZaGradjevinskuDozvoluId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOznaka(Integer oznaka) {
        this.oznaka = oznaka;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setVrstaPoda(String vrstaPoda) {
        this.vrstaPoda = vrstaPoda;
    }

    public void setProstorijaNaziv(String prostorijaNaziv) {
        this.prostorijaNaziv = prostorijaNaziv;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setVrstaPovrsineId(Integer vrstaPovrsineId) {
        this.vrstaPovrsineId = vrstaPovrsineId;
    }

    public void setProjekatZaGradjevinskuDozvoluId(Integer projekatZaGradjevinskuDozvoluId) {
        this.projekatZaGradjevinskuDozvoluId = projekatZaGradjevinskuDozvoluId;
    }
}
