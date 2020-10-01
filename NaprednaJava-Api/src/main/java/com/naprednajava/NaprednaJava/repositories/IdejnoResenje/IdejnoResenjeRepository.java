package com.naprednajava.NaprednaJava.repositories.IdejnoResenje;

import com.naprednajava.NaprednaJava.models.Enums.StatusDokumenta;
import com.naprednajava.NaprednaJava.models.IdejnoResenje;
import com.naprednajava.NaprednaJava.models.ProjekatZaGradjevinskuDozvolu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("idejnoResenje")
public class IdejnoResenjeRepository implements IIdejnoResenjeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IdejnoResenjeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<IdejnoResenje> getAll() {
        final String sql = "SELECT * FROM idejnoresenje";

        List<IdejnoResenje> idejnaResenja = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String naziv = resultSet.getString("Naziv");
            Date datumIzrade = resultSet.getDate("DatumIzrade");
            Integer glavniProjektantId = resultSet.getInt("GlavniProjektantId");
            Integer objekatId = resultSet.getInt("ObjekatId");
            Integer lokacijskaDozvolaId = resultSet.getInt("LokacijskaDozvolaId");
            return new IdejnoResenje(id, naziv, datumIzrade, glavniProjektantId, objekatId, lokacijskaDozvolaId);
        });

        for (IdejnoResenje ir : idejnaResenja) {
            final String sql2 = "SELECT * FROM projekatzagradjevinskudozvolu WHERE IdejnoResenjeId = " + ir.getId() + " ";

            List<ProjekatZaGradjevinskuDozvolu> projektiZaGradjevinskuDozvolu = jdbcTemplate.query(sql2, (resultSet, i) -> {
                Integer id = resultSet.getInt("Id");
                String naziv = resultSet.getString("Naziv");
                Date datumIzrade = resultSet.getDate("DatumIzrade");
                String nazivIdejnogResenja = resultSet.getString("NazivIdejnogResenja");
                StatusDokumenta statusDokumenta = StatusDokumenta.values()[resultSet.getInt("StatusDokumenta")];
                Integer idejnoResenjeId = resultSet.getInt("IdejnoResenjeId");
                return new ProjekatZaGradjevinskuDozvolu(id, naziv, datumIzrade, nazivIdejnogResenja, statusDokumenta, idejnoResenjeId);
            });

            ir.setProjektiZaGradjevinskuDozvolu(projektiZaGradjevinskuDozvolu);
        }

        return idejnaResenja;
    }

    @Override
    public int insert(IdejnoResenje idejnoResenje) {
        final String sql = "INSERT INTO idejnoresenje (Naziv, DatumIzrade, GlavniProjektantId, ObjekatId, LokacijskaDozvolaId) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, idejnoResenje.getNaziv(), idejnoResenje.getDatumIzrade(), idejnoResenje.getGlavniProjektantId(), idejnoResenje.getObjekatId(), idejnoResenje.getLokacijskaDozvolaId());

        return 0;
    }

    @Override
    public int update(Integer id, IdejnoResenje idejnoResenje) {
        final String sql = "UPDATE idejnoresenje SET Naziv = ?, DatumIzrade = ?, GlavniProjektantId = ?, ObjekatId = ?, LokacijskaDozvolaId = ? WHERE Id = ?";

        jdbcTemplate.update(sql, idejnoResenje.getNaziv(), idejnoResenje.getDatumIzrade(), idejnoResenje.getGlavniProjektantId(), idejnoResenje.getObjekatId(), idejnoResenje.getLokacijskaDozvolaId(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM idejnoresenje WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}