package com.naprednajava.NaprednaJava.repositories.ProjekatZaGradjevinskuDozvolu;

import com.naprednajava.NaprednaJava.models.Enums.Status;
import com.naprednajava.NaprednaJava.models.Enums.StatusDokumenta;
import com.naprednajava.NaprednaJava.models.Povrsina;
import com.naprednajava.NaprednaJava.models.ProjekatZaGradjevinskuDozvolu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.List;

@Repository("projekatZaGradjevinskuDozvolu")
public class ProjekatZaGradjevinskuDozvoluRepository implements IProjekatZaGradjevinskuDozvoluRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjekatZaGradjevinskuDozvoluRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProjekatZaGradjevinskuDozvolu> getAll() {
        final String sql = "SELECT * FROM projekatzagradjevinskudozvolu";

        List<ProjekatZaGradjevinskuDozvolu> projektiZaGradjevinskuDozvolu = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String naziv = resultSet.getString("Naziv");
            Date datumIzrade = resultSet.getDate("DatumIzrade");
            String nazivIdejnogResenja = resultSet.getString("NazivIdejnogResenja");
            StatusDokumenta statusDokumenta = StatusDokumenta.values()[resultSet.getInt("StatusDokumenta")];
            Integer idejnoResenjeId = resultSet.getInt("IdejnoResenjeId");
            return new ProjekatZaGradjevinskuDozvolu(id, naziv, datumIzrade, nazivIdejnogResenja, statusDokumenta, idejnoResenjeId);
        });

        for (ProjekatZaGradjevinskuDozvolu pgd : projektiZaGradjevinskuDozvolu) {
            final String sql2 = "SELECT * FROM povrsina WHERE ProjekatZaGradjevinskuDozvoluId = " + pgd.getId() + " ";

            List<Povrsina> povrsine = jdbcTemplate.query(sql2, (resultSet, i) -> {
                Integer id = resultSet.getInt("Id");
                Integer oznaka = resultSet.getInt("Oznaka");
                String naziv = resultSet.getString("Naziv");
                String vrstaPoda = resultSet.getString("VrstaPoda");
                Integer projekatZaGradjevinskuDozvoluId = resultSet.getInt("ProjekatZaGradjevinskuDozvoluId");
                Integer vrstaPovrsineId = resultSet.getInt("VrstaPovrsineId");
                String prostorijaNaziv = resultSet.getString("ProstorijaNaziv");
                Status status = Status.values()[resultSet.getInt("Status")];
                return new Povrsina(id, oznaka, naziv, vrstaPoda, prostorijaNaziv, status, vrstaPovrsineId, projekatZaGradjevinskuDozvoluId);
            });

            pgd.setPovrsine(povrsine);
        }

        return projektiZaGradjevinskuDozvolu;
    }

    @Override
    public int insert(ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {
        final String sql = "INSERT INTO projekatzagradjevinskudozvolu (Naziv, DatumIzrade, NazivIdejnogResenja, IdejnoResenjeId, StatusDokumenta) VALUES (?, ?, ?, ?, ?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, projekatZaGradjevinskuDozvolu.getNaziv());
                statement.setDate(2, new java.sql.Date((new java.util.Date()).getTime()));
                statement.setString(3, projekatZaGradjevinskuDozvolu.getNazivIdejnogResenja());
                statement.setInt(4, projekatZaGradjevinskuDozvolu.getIdejnoResenjeId());
                statement.setInt(5, projekatZaGradjevinskuDozvolu.getStatusDokumenta().ordinal());
                return statement;
            }
        }, holder);

        return holder.getKey().intValue();
    }

    @Override
    public int update(Integer id, ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {
        final String sql = "UPDATE projekatzagradjevinskudozvolu SET Naziv = ?, DatumIzrade = ?, NazivIdejnogResenja = ?, IdejnoResenjeId = ?, StatusDokumenta = ? WHERE Id = ?";

        jdbcTemplate.update(sql, projekatZaGradjevinskuDozvolu.getNaziv(), projekatZaGradjevinskuDozvolu.getDatumIzrade(), projekatZaGradjevinskuDozvolu.getNazivIdejnogResenja(), projekatZaGradjevinskuDozvolu.getIdejnoResenjeId(), projekatZaGradjevinskuDozvolu.getStatusDokumenta().ordinal(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM projekatzagradjevinskudozvolu WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}