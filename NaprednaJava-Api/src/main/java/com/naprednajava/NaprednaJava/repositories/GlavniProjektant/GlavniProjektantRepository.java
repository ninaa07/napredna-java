package com.naprednajava.NaprednaJava.repositories.GlavniProjektant;

import com.naprednajava.NaprednaJava.models.GlavniProjektant;
import com.naprednajava.NaprednaJava.models.IdejnoResenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("glavniProjektant")
public class GlavniProjektantRepository implements IGlavniProjektantRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GlavniProjektantRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GlavniProjektant> getAll() {
        final String sql = "SELECT * FROM glavniprojektant";

        List<GlavniProjektant> glavniProjektanti = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String imePrezime = resultSet.getString("ImePrezime");
            Long brojLicence = resultSet.getLong("BrojLicence");
            String zvanje = resultSet.getString("Zvanje");
            return new GlavniProjektant(id, imePrezime, brojLicence, zvanje);
        });

        for (GlavniProjektant gp: glavniProjektanti) {
            final String sql2 = "SELECT * FROM idejnoresenje WHERE GlavniProjektantId = "+gp.getId()+" ";

            List<IdejnoResenje> idejnaResenja = jdbcTemplate.query(sql2, (resultSet, i) -> {
                Integer id = resultSet.getInt("Id");
                String naziv = resultSet.getString("Naziv");
                Date datumIzrade = resultSet.getDate("DatumIzrade");
                Integer glavniProjektantId = resultSet.getInt("GlavniProjektantId");
                Integer objekatId = resultSet.getInt("ObjekatId");
                Integer lokacijskaDozvolaId = resultSet.getInt("LokacijskaDozvolaId");
                return new IdejnoResenje(id, naziv, datumIzrade, glavniProjektantId, objekatId, lokacijskaDozvolaId);
            });

            gp.setIdejnaResenja(idejnaResenja);
        }

        return glavniProjektanti;
    }

    @Override
    public int insert(GlavniProjektant glavniProjektant) {
        final String sql = "INSERT INTO glavniprojektant (ImePrezime, BrojLicence, Zvanje) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, glavniProjektant.getImePrezime(), glavniProjektant.getBrojLicence(), glavniProjektant.getZvanje());

        return 0;
    }

    @Override
    public int update(Integer id, GlavniProjektant glavniProjektant) {
        final String sql = "UPDATE glavniprojektant SET ImePrezime = ?, BrojLicence = ?, Zvanje = ? WHERE Id = ?";

        jdbcTemplate.update(sql, glavniProjektant.getImePrezime(), glavniProjektant.getBrojLicence(), glavniProjektant.getZvanje(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM glavniprojektant WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}
