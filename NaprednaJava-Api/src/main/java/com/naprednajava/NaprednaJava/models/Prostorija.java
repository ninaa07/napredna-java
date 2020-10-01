package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Prostorija {

    private final Integer id;

    @NotBlank
    private String naziv;

    @NotBlank
    private Integer vrstaPovrsineId;

    public Prostorija(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("vrstaPovrsineId") Integer vrstaPovrsineId) {
        this.id = id;
        this.naziv = naziv;
        this.vrstaPovrsineId = vrstaPovrsineId;
    }

    public Integer getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public Integer getVrstaPovrsineId() {
        return vrstaPovrsineId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setVrstaPovrsineId(Integer vrstaPovrsineId) {
        this.vrstaPovrsineId = vrstaPovrsineId;
    }
}
