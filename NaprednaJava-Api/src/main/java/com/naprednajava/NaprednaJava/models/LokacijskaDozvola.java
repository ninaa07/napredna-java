package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LokacijskaDozvola {

    private final UUID id;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final String opstiPodaci;

    @NotBlank
    private final String lokacijskiUslovi;

    @NotBlank
    private final Long brojParcele;

    @NotBlank
    private final Long povrsinaParcele;

    @NotBlank
    private final String nazivIdejnogResenja;

    @NotBlank
    private final Date datumIzdavanja;

    @NotBlank
    private final UUID informacijeOLokacijiId;

    private final InformacijeOLokaciji informacijeOLokaciji;

    private final List<IdejnoResenje> idejnaResenja;

    public LokacijskaDozvola(@JsonProperty("id") UUID id, @JsonProperty("naziv") String naziv, @JsonProperty("opstiPodaci") String opstiPodaci, @JsonProperty("lokacijskiUslovi") String lokacijskiUslovi, @JsonProperty("brojParcele") Long brojParcele, @JsonProperty("povrsinaParcele") Long povrsinaParcele, @JsonProperty("nazivIdejnogResenja") String nazivIdejnogResenja, @JsonProperty("datumIzdavanja") Date datumIzdavanja, @JsonProperty("informacijeOLokacijiId") UUID informacijeOLokacijiId, InformacijeOLokaciji informacijeOLokaciji) {
        this.id = id;
        this.naziv = naziv;
        this.opstiPodaci = opstiPodaci;
        this.lokacijskiUslovi = lokacijskiUslovi;
        this.brojParcele = brojParcele;
        this.povrsinaParcele = povrsinaParcele;
        this.nazivIdejnogResenja = nazivIdejnogResenja;
        this.datumIzdavanja = datumIzdavanja;
        this.informacijeOLokacijiId = informacijeOLokacijiId;
        this.informacijeOLokaciji = informacijeOLokaciji;
        idejnaResenja = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpstiPodaci() {
        return opstiPodaci;
    }

    public String getLokacijskiUslovi() {
        return lokacijskiUslovi;
    }

    public Long getBrojParcele() {
        return brojParcele;
    }

    public Long getPovrsinaParcele() {
        return povrsinaParcele;
    }

    public String getNazivIdejnogResenja() {
        return nazivIdejnogResenja;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public UUID getInformacijeOLokacijiId() {
        return informacijeOLokacijiId;
    }

    public InformacijeOLokaciji getInformacijeOLokaciji() {
        return informacijeOLokaciji;
    }

    public List<IdejnoResenje> getIdejnaResenja() {
        return idejnaResenja;
    }
}
