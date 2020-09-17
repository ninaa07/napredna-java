package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GlavniProjektant {

    private final UUID id;

    @NotBlank
    private final String imePrezime;

    @NotBlank
    private final Long brojLicence;

    @NotBlank
    private final String zvanje;

    private final List<IdejnoResenje> idejnaResenja;

    public GlavniProjektant(@JsonProperty("id") UUID id, @JsonProperty("imePrezime") String imePrezime, @JsonProperty("brojLicence") Long brojLicence, @JsonProperty("zvanje") String zvanje) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.brojLicence = brojLicence;
        this.zvanje = zvanje;
        idejnaResenja = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public Long getBrojLicence() {
        return brojLicence;
    }

    public String getZvanje() {
        return zvanje;
    }

    public List<IdejnoResenje> getIdejnaResenja() {
        return idejnaResenja;
    }
}
