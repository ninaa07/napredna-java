package com.naprednajava.NaprednaJava.repositories.LokacijskaDozvola;

import com.naprednajava.NaprednaJava.models.IdejnoResenje;
import com.naprednajava.NaprednaJava.models.LokacijskaDozvola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

@Repository("lokacijskaDozvola")
public class LokacijskaDozvolaRepository implements ILokacijskaDozvolaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LokacijskaDozvolaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LokacijskaDozvola> getAll() {
        final String sql = "SELECT * FROM lokacijskadozvola";

        List<LokacijskaDozvola> lokacijskeDozvole = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String naziv = resultSet.getString("Naziv");
            String opstiPodaci = resultSet.getString("OpstiPodaci");
            String lokacijskiUslovi = resultSet.getString("LokacijskiUslovi");
            Long brojParcele = resultSet.getLong("BrojParcele");
            Long povrsinaParcele = resultSet.getLong("PovrsinaParcele");
            String nazivIdejnogResenja = resultSet.getString("NazivIdejnogResenja");
            Date datumIzdavanja = resultSet.getDate("DatumIzdavanja");
            Integer informacijeOLokacijiId = resultSet.getInt("InformacijeOLokacijiId");
            return new LokacijskaDozvola(id, naziv, opstiPodaci, lokacijskiUslovi, brojParcele, povrsinaParcele, nazivIdejnogResenja, datumIzdavanja, informacijeOLokacijiId);
        });

        for (LokacijskaDozvola ld : lokacijskeDozvole) {
            final String sql2 = "SELECT * FROM idejnoresenje WHERE LokacijskaDozvolaId = " + ld.getId() + " ";

            List<IdejnoResenje> idejnaResenja = jdbcTemplate.query(sql2, (resultSet, i) -> {
                Integer id = resultSet.getInt("Id");
                String naziv = resultSet.getString("Naziv");
                Date datumIzrade = resultSet.getDate("DatumIzrade");
                Integer glavniProjektantId = resultSet.getInt("GlavniProjektantId");
                Integer objekatId = resultSet.getInt("ObjekatId");
                Integer lokacijskaDozvolaId = resultSet.getInt("LokacijskaDozvolaId");
                return new IdejnoResenje(id, naziv, datumIzrade, glavniProjektantId, objekatId, lokacijskaDozvolaId);
            });

            ld.setIdejnaResenja(idejnaResenja);
        }

        return lokacijskeDozvole;
    }

    @Override
    public int insert(LokacijskaDozvola lokacijskaDozvola) {

        final String sql = "INSERT INTO lokacijskadozvola (Naziv, OpstiPodaci, LokacijskiUslovi, BrojParcele, PovrsinaParcele, DatumIzdavanja, InformacijeOLokacijiId, NazivIdejnogResenja) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, lokacijskaDozvola.getNaziv());
                statement.setString(2, lokacijskaDozvola.getOpstiPodaci());
                statement.setString(3, lokacijskaDozvola.getLokacijskiUslovi());
                statement.setLong(4, lokacijskaDozvola.getBrojParcele());
                statement.setLong(5, lokacijskaDozvola.getPovrsinaParcele());
                statement.setDate(6, new java.sql.Date((new java.util.Date()).getTime()));
                statement.setInt(7, lokacijskaDozvola.getInformacijeOLokacijiId());
                statement.setString(8, lokacijskaDozvola.getNazivIdejnogResenja());
                return statement;
            }
        }, holder);

        return holder.getKey().intValue();
    }

    @Override
    public int update(Integer id, LokacijskaDozvola lokacijskaDozvola) {
        final String sql = "UPDATE lokacijskadozvola SET Naziv = ?, OpstiPodaci = ?, LokacijskiUslovi = ?, BrojParcele = ?, PovrsinaParcele = ?, DatumIzdavanja = ?, InformacijeOLokacijiId = ?, NazivIdejnogResenja = ? WHERE Id = ?";

        jdbcTemplate.update(sql, lokacijskaDozvola.getNaziv(), lokacijskaDozvola.getOpstiPodaci(), lokacijskaDozvola.getLokacijskiUslovi(), lokacijskaDozvola.getBrojParcele(), lokacijskaDozvola.getPovrsinaParcele(), lokacijskaDozvola.getDatumIzdavanja(), lokacijskaDozvola.getInformacijeOLokacijiId(), lokacijskaDozvola.getNazivIdejnogResenja(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM lokacijskadozvola WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}