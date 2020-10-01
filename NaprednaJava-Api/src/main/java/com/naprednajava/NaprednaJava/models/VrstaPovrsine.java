package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class VrstaPovrsine {

    private final Integer id;

    @NotBlank
    private String naziv;

    private List<Prostorija> prostorije;

    public VrstaPovrsine(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv) {
        this.id = id;
        this.naziv = naziv;
        prostorije = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public List<Prostorija> getProstorije() {
        return prostorije;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setProstorije(List<Prostorija> prostorije) {
        this.prostorije = prostorije;
    }
}
