package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LokacijskaDozvola {

    @NotBlank
    private Integer id;

    @NotBlank
    private String naziv;

    @NotBlank
    private String opstiPodaci;

    @NotBlank
    private String lokacijskiUslovi;

    @NotBlank
    private Long brojParcele;

    @NotBlank
    private Long povrsinaParcele;

    @NotBlank
    private String nazivIdejnogResenja;

    @NotBlank
    private Date datumIzdavanja;

    @NotBlank
    private Integer informacijeOLokacijiId;

    private List<IdejnoResenje> idejnaResenja;

    public LokacijskaDozvola(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("opstiPodaci") String opstiPodaci, @JsonProperty("lokacijskiUslovi") String lokacijskiUslovi, @JsonProperty("brojParcele") Long brojParcele, @JsonProperty("povrsinaParcele") Long povrsinaParcele, @JsonProperty("nazivIdejnogResenja") String nazivIdejnogResenja, @JsonProperty("datumIzdavanja") Date datumIzdavanja, @JsonProperty("informacijeOLokacijiId") Integer informacijeOLokacijiId) {
        this.id = id;
        this.naziv = naziv;
        this.opstiPodaci = opstiPodaci;
        this.lokacijskiUslovi = lokacijskiUslovi;
        this.brojParcele = brojParcele;
        this.povrsinaParcele = povrsinaParcele;
        this.nazivIdejnogResenja = nazivIdejnogResenja;
        this.datumIzdavanja = datumIzdavanja;
        this.informacijeOLokacijiId = informacijeOLokacijiId;
        idejnaResenja = new ArrayList<>();
    }

    public Integer getId() {
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

    public Integer getInformacijeOLokacijiId() {
        return informacijeOLokacijiId;
    }

    public List<IdejnoResenje> getIdejnaResenja() {
        return idejnaResenja;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpstiPodaci(String opstiPodaci) {
        this.opstiPodaci = opstiPodaci;
    }

    public void setLokacijskiUslovi(String lokacijskiUslovi) {
        this.lokacijskiUslovi = lokacijskiUslovi;
    }

    public void setBrojParcele(Long brojParcele) {
        this.brojParcele = brojParcele;
    }

    public void setPovrsinaParcele(Long povrsinaParcele) {
        this.povrsinaParcele = povrsinaParcele;
    }

    public void setNazivIdejnogResenja(String nazivIdejnogResenja) {
        this.nazivIdejnogResenja = nazivIdejnogResenja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public void setInformacijeOLokacijiId(Integer informacijeOLokacijiId) {
        this.informacijeOLokacijiId = informacijeOLokacijiId;
    }

    public void setIdejnaResenja(List<IdejnoResenje> idejnaResenja) {
        this.idejnaResenja = idejnaResenja;
    }
}
