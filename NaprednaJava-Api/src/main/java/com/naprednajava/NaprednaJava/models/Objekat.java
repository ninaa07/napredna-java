package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Objekat {

    private final Integer id;

    @NotBlank
    private String naziv;

    @NotBlank
    private BigDecimal dimenzije;

    @NotBlank
    private String karakteristike;

    private List<IdejnoResenje> idejnaResenja;

    public Objekat(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("dimenzije") BigDecimal dimenzije, @JsonProperty("karakteristike") String karakteristike) {
        this.id = id;
        this.naziv = naziv;
        this.dimenzije = dimenzije;
        this.karakteristike = karakteristike;
        idejnaResenja = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public BigDecimal getDimenzije() {
        return dimenzije;
    }

    public String getKarakteristike() {
        return karakteristike;
    }

    public List<IdejnoResenje> getIdejnaResenja() {
        return idejnaResenja;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setDimenzije(BigDecimal dimenzije) {
        this.dimenzije = dimenzije;
    }

    public void setKarakteristike(String karakteristike) {
        this.karakteristike = karakteristike;
    }

    public void setIdejnaResenja(List<IdejnoResenje> idejnaResenja) {
        this.idejnaResenja = idejnaResenja;
    }
}
