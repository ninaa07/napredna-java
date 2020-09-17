package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naprednajava.NaprednaJava.models.Enums.Status;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Povrsina {

    private final UUID id;

    @NotBlank
    private final Integer oznaka;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final String vrstaPoda;

    @NotBlank
    private final String prostorijaNaziv;

    @NotBlank
    private final Status status;

    @NotBlank
    private final UUID vrstaPovrsineId;

    private final VrstaPovrsine vrstaPovrsine;

    @NotBlank
    private final UUID projekatZaGradjevinskuDozvoluId;

    private final ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu;

    public Povrsina(@JsonProperty("id") UUID id, @JsonProperty("oznaka") Integer oznaka, @JsonProperty("naziv")  String naziv, @JsonProperty("vrstaPoda")  String vrstaPoda, @JsonProperty("prostorijaNaziv")  String prostorijaNaziv, @JsonProperty("status")  Status status, @JsonProperty("vrstaPovrsineId")  UUID vrstaPovrsineId, VrstaPovrsine vrstaPovrsine, @JsonProperty("projekatZaGradjevinskuDozvoluId") UUID projekatZaGradjevinskuDozvoluId, ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {
        this.id = id;
        this.oznaka = oznaka;
        this.naziv = naziv;
        this.vrstaPoda = vrstaPoda;
        this.prostorijaNaziv = prostorijaNaziv;
        this.status = status;
        this.vrstaPovrsineId = vrstaPovrsineId;
        this.vrstaPovrsine = vrstaPovrsine;
        this.projekatZaGradjevinskuDozvoluId = projekatZaGradjevinskuDozvoluId;
        this.projekatZaGradjevinskuDozvolu = projekatZaGradjevinskuDozvolu;
    }

    public UUID getId() {
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

    public UUID getVrstaPovrsineId() {
        return vrstaPovrsineId;
    }

    public VrstaPovrsine getVrstaPovrsine() {
        return vrstaPovrsine;
    }

    public UUID getProjekatZaGradjevinskuDozvoluId() {
        return projekatZaGradjevinskuDozvoluId;
    }

    public ProjekatZaGradjevinskuDozvolu getProjekatZaGradjevinskuDozvolu() {
        return projekatZaGradjevinskuDozvolu;
    }
}
