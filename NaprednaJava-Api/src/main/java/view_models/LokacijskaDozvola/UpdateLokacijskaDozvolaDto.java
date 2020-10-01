package view_models.LokacijskaDozvola;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UpdateLokacijskaDozvolaDto {

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
    private Date datumIzdavanja;

    @NotBlank
    private Integer informacijeOLokacijiId;

    @NotBlank
    private String nazivIdejnogResenja;

    public UpdateLokacijskaDozvolaDto(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("opstiPodaci") String opstiPodaci, @JsonProperty("lokacijskiUslovi") String lokacijskiUslovi, @JsonProperty("brojParcele") Long brojParcele, @JsonProperty("povrsinaParcele") Long povrsinaParcele, @JsonProperty("nazivIdejnogResenja") String nazivIdejnogResenja, @JsonProperty("datumIzdavanja") Date datumIzdavanja, @JsonProperty("informacijeOLokacijiId") Integer informacijeOLokacijiId) {
        this.id = id;
        this.naziv = naziv;
        this.opstiPodaci = opstiPodaci;
        this.lokacijskiUslovi = lokacijskiUslovi;
        this.brojParcele = brojParcele;
        this.povrsinaParcele = povrsinaParcele;
        this.nazivIdejnogResenja = nazivIdejnogResenja;
        this.datumIzdavanja = datumIzdavanja;
        this.informacijeOLokacijiId = informacijeOLokacijiId;
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

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public Integer getInformacijeOLokacijiId() {
        return informacijeOLokacijiId;
    }

    public String getNazivIdejnogResenja() {
        return nazivIdejnogResenja;
    }
}
