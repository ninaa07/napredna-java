package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Objekat {

    private final UUID id;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final BigDecimal dimenzije;

    @NotBlank
    private final String karakteristike;

    private final List<IdejnoResenje> idejnaResenja;

    public Objekat(@JsonProperty("id") UUID id, @JsonProperty("naziv") String naziv, @JsonProperty("dimenzije") BigDecimal dimenzije, @JsonProperty("karakteristike") String karakteristike) {
        this.id = id;
        this.naziv = naziv;
        this.dimenzije = dimenzije;
        this.karakteristike = karakteristike;
        idejnaResenja = new ArrayList<>();
    }

    public UUID getId() {
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
}
