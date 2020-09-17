package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Prostorija {

    private final UUID id;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final UUID vrstaPovrsineId;

    private final VrstaPovrsine vrstaPovrsine;

    public Prostorija(@JsonProperty("id") UUID id, @JsonProperty("naziv") String naziv, @JsonProperty("vrstaPovrsineId") UUID vrstaPovrsineId, VrstaPovrsine vrstaPovrsine) {
        this.id = id;
        this.naziv = naziv;
        this.vrstaPovrsineId = vrstaPovrsineId;
        this.vrstaPovrsine = vrstaPovrsine;
    }

    public UUID getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public UUID getVrstaPovrsineId() {
        return vrstaPovrsineId;
    }

    public VrstaPovrsine getVrstaPovrsine() {
        return vrstaPovrsine;
    }
}
