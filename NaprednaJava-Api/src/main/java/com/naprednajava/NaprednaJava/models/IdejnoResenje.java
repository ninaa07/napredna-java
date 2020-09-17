package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class IdejnoResenje {

    private final UUID id;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final Date datumIzrade;

    @NotBlank
    private final UUID glavniProjektantId;

    private final GlavniProjektant glavniProjektant;

    @NotBlank
    private final UUID objekatId;

    private final Objekat objekat;

    @NotBlank
    private final UUID lokacijskaDozvolaId;

    private final LokacijskaDozvola lokacijskaDozvola;

    private final List<ProjekatZaGradjevinskuDozvolu> projektiZaGradjevinskuDozvolu;

    public IdejnoResenje(@JsonProperty("id") UUID id, @JsonProperty("naziv") String naziv, @JsonProperty("datumIzrade") Date datumIzrade, @JsonProperty("glavniProjektantId") UUID glavniProjektantId, GlavniProjektant glavniProjektant, @JsonProperty("objekatId") UUID objekatId, Objekat objekat, @JsonProperty("lokacijskaDozvolaId") UUID lokacijskaDozvolaId, LokacijskaDozvola lokacijskaDozvola) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzrade = datumIzrade;
        this.glavniProjektantId = glavniProjektantId;
        this.glavniProjektant = glavniProjektant;
        this.objekatId = objekatId;
        this.objekat = objekat;
        this.lokacijskaDozvolaId = lokacijskaDozvolaId;
        this.lokacijskaDozvola = lokacijskaDozvola;
        projektiZaGradjevinskuDozvolu = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public Date getDatumIzrade() {
        return datumIzrade;
    }

    public UUID getGlavniProjektantId() {
        return glavniProjektantId;
    }

    public GlavniProjektant getGlavniProjektant() {
        return glavniProjektant;
    }

    public UUID getObjekatId() {
        return objekatId;
    }

    public Objekat getObjekat() {
        return objekat;
    }

    public UUID getLokacijskaDozvolaId() {
        return lokacijskaDozvolaId;
    }

    public LokacijskaDozvola getLokacijskaDozvola() {
        return lokacijskaDozvola;
    }

    public List<ProjekatZaGradjevinskuDozvolu> getProjektiZaGradjevinskuDozvolu() {
        return projektiZaGradjevinskuDozvolu;
    }
}
