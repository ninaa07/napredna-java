package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VrstaPovrsine {

    private final UUID id;

    @NotBlank
    private final String naziv;

    private final List<Prostorija> prostorije;

    public VrstaPovrsine(@JsonProperty("id") UUID id, @JsonProperty("naziv") String naziv) {
        this.id = id;
        this.naziv = naziv;
        prostorije = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public List<Prostorija> getProstorije() {
        return prostorije;
    }
}
