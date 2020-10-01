package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformacijeOLokaciji {

    private final Integer id;

    @NotBlank
    private String naziv;

    @NotBlank
    private Date datumIzdavanja;

    @NotBlank
    private String namenaZemljista;

    @NotBlank
    private String zona;

    private List<LokacijskaDozvola> lokacijskeDozvole;

    public InformacijeOLokaciji(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("datumIzdavanja") Date datumIzdavanja, @JsonProperty("namenaZemljista") String namenaZemljista, @JsonProperty("zona") String zona) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzdavanja = datumIzdavanja;
        this.namenaZemljista = namenaZemljista;
        this.zona = zona;
        lokacijskeDozvole = new ArrayList<>();
    }

    public Integer getId() {
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

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public void setNamenaZemljista(String namenaZemljista) {
        this.namenaZemljista = namenaZemljista;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setLokacijskeDozvole(List<LokacijskaDozvola> lokacijskeDozvole) {
        this.lokacijskeDozvole = lokacijskeDozvole;
    }
}
