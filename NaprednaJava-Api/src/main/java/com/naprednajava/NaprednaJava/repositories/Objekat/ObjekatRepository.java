package com.naprednajava.NaprednaJava.repositories.Objekat;

import com.naprednajava.NaprednaJava.models.IdejnoResenje;
import com.naprednajava.NaprednaJava.models.Objekat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository("objekat")
public class ObjekatRepository implements IObjekatRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ObjekatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Objekat> getAll() {
        final String sql = "SELECT * FROM objekat";

        List<Objekat> objekti = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String naziv = resultSet.getString("Naziv");
            BigDecimal dimenzije = resultSet.getBigDecimal("Dimenzije");
            String karakteristike = resultSet.getString("Karakteristike");
            return new Objekat(id, naziv, dimenzije, karakteristike);
        });

        for (Objekat o : objekti) {
            final String sql2 = "SELECT * FROM idejnoresenje WHERE ObjekatId = " + o.getId() + " ";

            List<IdejnoResenje> idejnaResenja = jdbcTemplate.query(sql2, (resultSet, i) -> {
                Integer id = resultSet.getInt("Id");
                String naziv = resultSet.getString("Naziv");
                Date datumIzrade = resultSet.getDate("DatumIzrade");
                Integer glavniProjektantId = resultSet.getInt("GlavniProjektantId");
                Integer objekatId = resultSet.getInt("ObjekatId");
                Integer lokacijskaDozvolaId = resultSet.getInt("LokacijskaDozvolaId");
                return new IdejnoResenje(id, naziv, datumIzrade, glavniProjektantId, objekatId, lokacijskaDozvolaId);
            });

            o.setIdejnaResenja(idejnaResenja);
        }

        return objekti;
    }

    @Override
    public int insert(Objekat objekat) {
        final String sql = "INSERT INTO objekat (Naziv, Dimenzije, Karakteristike) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, objekat.getNaziv(), objekat.getDimenzije(), objekat.getKarakteristike());

        return 0;
    }

    @Override
    public int update(Integer id, Objekat objekat) {
        final String sql = "UPDATE objekat SET Naziv = ?, Dimenzije = ?, Karakteristike = ? WHERE Id = ?";

        jdbcTemplate.update(sql, objekat.getNaziv(), objekat.getDimenzije(), objekat.getKarakteristike(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM objekat WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}
