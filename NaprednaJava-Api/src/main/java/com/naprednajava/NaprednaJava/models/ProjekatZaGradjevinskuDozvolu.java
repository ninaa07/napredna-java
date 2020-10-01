package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naprednajava.NaprednaJava.models.Enums.StatusDokumenta;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjekatZaGradjevinskuDozvolu {

    @NotBlank
    private Integer id;

    @NotBlank
    private String naziv;

    @NotBlank
    private Date datumIzrade;

    @NotBlank
    private String nazivIdejnogResenja;

    @NotBlank
    private StatusDokumenta statusDokumenta;

    @NotBlank
    private Integer idejnoResenjeId;

    private List<Povrsina> povrsine;

    public ProjekatZaGradjevinskuDozvolu(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("datumIzrade") Date datumIzrade, @JsonProperty("nazivIdejnogResenja") String nazivIdejnogResenja, @JsonProperty("statusDokumenta") StatusDokumenta statusDokumenta, @JsonProperty("idejnoResenjeId") Integer idejnoResenjeId) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzrade = datumIzrade;
        this.nazivIdejnogResenja = nazivIdejnogResenja;
        this.statusDokumenta = statusDokumenta;
        this.idejnoResenjeId = idejnoResenjeId;
        povrsine = new ArrayList<>();
    }

    public Integer getId() {
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

    public Integer getIdejnoResenjeId() {
        return idejnoResenjeId;
    }

    public List<Povrsina> getPovrsine() {
        return povrsine;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setDatumIzrade(Date datumIzrade) {
        this.datumIzrade = datumIzrade;
    }

    public void setNazivIdejnogResenja(String nazivIdejnogResenja) {
        this.nazivIdejnogResenja = nazivIdejnogResenja;
    }

    public void setStatusDokumenta(StatusDokumenta statusDokumenta) {
        this.statusDokumenta = statusDokumenta;
    }

    public void setIdejnoResenjeId(Integer idejnoResenjeId) {
        this.idejnoResenjeId = idejnoResenjeId;
    }

    public void setPovrsine(List<Povrsina> povrsine) {
        this.povrsine = povrsine;
    }
}
