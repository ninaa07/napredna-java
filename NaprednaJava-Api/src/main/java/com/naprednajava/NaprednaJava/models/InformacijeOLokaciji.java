package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class InformacijeOLokaciji {

    private final UUID id;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final Date datumIzdavanja;

    @NotBlank
    private final String namenaZemljista;

    @NotBlank
    private final String zona;

    private final List<LokacijskaDozvola> lokacijskeDozvole;

    public InformacijeOLokaciji(@JsonProperty("id") UUID id, @JsonProperty("naziv") String naziv, @JsonProperty("datumIzdavanja") Date datumIzdavanja, @JsonProperty("namenaZemljista") String namenaZemljista, @JsonProperty("zona") String zona) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzdavanja = datumIzdavanja;
        this.namenaZemljista = namenaZemljista;
        this.zona = zona;
        lokacijskeDozvole = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public String getNamenaZemljista() {
        return namenaZemljista;
    }

    public String getZona() {
        return zona;
    }

    public List<LokacijskaDozvola> getLokacijskeDozvole() {
        return lokacijskeDozvole;
    }
}
