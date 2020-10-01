package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class GlavniProjektant {

    @NotBlank
    private Integer id;

    @NotBlank
    private String imePrezime;

    @NotBlank
    private Long brojLicence;

    @NotBlank
    private String zvanje;

    private List<IdejnoResenje> idejnaResenja;

    public GlavniProjektant(@JsonProperty("id") Integer id, @JsonProperty("imePrezime") String imePrezime, @JsonProperty("brojLicence") Long brojLicence, @JsonProperty("zvanje") String zvanje) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.brojLicence = brojLicence;
        this.zvanje = zvanje;
        idejnaResenja = new ArrayList<>();
    }

    public Integer getId() {
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

    public void setId(Integer id) { this.id = id; }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public void setBrojLicence(Long brojLicence) {
        this.brojLicence = brojLicence;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }

    public void setIdejnaResenja(List<IdejnoResenje> idejnaResenja) {
        this.idejnaResenja = idejnaResenja;
    }
}
