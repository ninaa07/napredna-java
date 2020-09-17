package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naprednajava.NaprednaJava.models.Enums.StatusDokumenta;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ProjekatZaGradjevinskuDozvolu {

    private final UUID id;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final Date datumIzrade;

    @NotBlank
    private final String nazivIdejnogResenja;

    @NotBlank
    private final StatusDokumenta statusDokumenta;

    @NotBlank
    private final UUID idejnoResenjeId;

    private final IdejnoResenje idejnoResenje;

    private final List<Povrsina> povrsine;

    public ProjekatZaGradjevinskuDozvolu(@JsonProperty("id") UUID id, @JsonProperty("naziv") String naziv, @JsonProperty("datumIzrade") Date datumIzrade, @JsonProperty("nazivIdejnogResenja") String nazivIdejnogResenja, @JsonProperty("statusDokumenta") StatusDokumenta statusDokumenta, @JsonProperty("idejnoResenjeId") UUID idejnoResenjeId, IdejnoResenje idejnoResenje) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzrade = datumIzrade;
        this.nazivIdejnogResenja = nazivIdejnogResenja;
        this.statusDokumenta = statusDokumenta;
        this.idejnoResenjeId = idejnoResenjeId;
        this.idejnoResenje = idejnoResenje;
        povrsine = new ArrayList<>();
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

    public String getNazivIdejnogResenja() {
        return nazivIdejnogResenja;
    }

    public StatusDokumenta getStatusDokumenta() {
        return statusDokumenta;
    }

    public UUID getIdejnoResenjeId() {
        return idejnoResenjeId;
    }

    public IdejnoResenje getIdejnoResenje() {
        return idejnoResenje;
    }

    public List<Povrsina> getPovrsine() {
        return povrsine;
    }
}
