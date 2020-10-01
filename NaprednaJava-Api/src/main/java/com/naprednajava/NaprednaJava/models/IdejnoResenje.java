package com.naprednajava.NaprednaJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IdejnoResenje {

    private final Integer id;

    @NotBlank
    private String naziv;

    @NotBlank
    private Date datumIzrade;

    @NotBlank
    private Integer glavniProjektantId;

    @NotBlank
    private Integer objekatId;

    @NotBlank
    private Integer lokacijskaDozvolaId;

    private List<ProjekatZaGradjevinskuDozvolu> projektiZaGradjevinskuDozvolu;

    public IdejnoResenje(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("datumIzrade") Date datumIzrade, @JsonProperty("glavniProjektantId") Integer glavniProjektantId, @JsonProperty("objekatId") Integer objekatId, @JsonProperty("lokacijskaDozvolaId") Integer lokacijskaDozvolaId) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzrade = datumIzrade;
        this.glavniProjektantId = glavniProjektantId;
        this.objekatId = objekatId;
        this.lokacijskaDozvolaId = lokacijskaDozvolaId;
        projektiZaGradjevinskuDozvolu = new ArrayList<>();
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

    public Integer getGlavniProjektantId() {
        return glavniProjektantId;
    }

    public Integer getObjekatId() {
        return objekatId;
    }

    public Integer getLokacijskaDozvolaId() {
        return lokacijskaDozvolaId;
    }

    public List<ProjekatZaGradjevinskuDozvolu> getProjektiZaGradjevinskuDozvolu() {
        return projektiZaGradjevinskuDozvolu;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setDatumIzrade(Date datumIzrade) {
        this.datumIzrade = datumIzrade;
    }

    public void setGlavniProjektantId(Integer glavniProjektantId) {
        this.glavniProjektantId = glavniProjektantId;
    }

    public void setObjekatId(Integer objekatId) {
        this.objekatId = objekatId;
    }

    public void setLokacijskaDozvolaId(Integer lokacijskaDozvolaId) {
        this.lokacijskaDozvolaId = lokacijskaDozvolaId;
    }

    public void setProjektiZaGradjevinskuDozvolu(List<ProjekatZaGradjevinskuDozvolu> projektiZaGradjevinskuDozvolu) {
        this.projektiZaGradjevinskuDozvolu = projektiZaGradjevinskuDozvolu;
    }
}
