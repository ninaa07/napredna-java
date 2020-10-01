package view_models.ProjekatZaGradjevinskuDozvolu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naprednajava.NaprednaJava.models.Enums.StatusDokumenta;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProjekatZaGradjevinskuDozvoluDto {

    private final Integer id;

    @NotBlank
    private final String naziv;

    @NotBlank
    private final Date datumIzrade;

    @NotBlank
    private final String nazivIdejnogResenja;

    @NotBlank
    private final Integer idejnoResenjeId;

    @NotBlank
    private final StatusDokumenta statusDokumenta;

    public ProjekatZaGradjevinskuDozvoluDto(@JsonProperty("id") Integer id, @JsonProperty("naziv") String naziv, @JsonProperty("datumIzrade") Date datumIzrade, @JsonProperty("nazivIdejnogResenja") String nazivIdejnogResenja, @JsonProperty("statusDokumenta") StatusDokumenta statusDokumenta, @JsonProperty("idejnoResenjeId") Integer idejnoResenjeId) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzrade = datumIzrade;
        this.nazivIdejnogResenja = nazivIdejnogResenja;
        this.statusDokumenta = statusDokumenta;
        this.idejnoResenjeId = idejnoResenjeId;
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

    public Integer getIdejnoResenjeId() {
        return idejnoResenjeId;
    }

    public StatusDokumenta getStatusDokumenta() {
        return statusDokumenta;
    }
}
