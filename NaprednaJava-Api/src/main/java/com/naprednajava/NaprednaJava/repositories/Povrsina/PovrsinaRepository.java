package com.naprednajava.NaprednaJava.repositories.Povrsina;

import com.naprednajava.NaprednaJava.models.Enums.Status;
import com.naprednajava.NaprednaJava.models.Povrsina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository("povrsina")
public class PovrsinaRepository implements IPovrsinaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PovrsinaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Povrsina> getAll() {
        final String sql = "SELECT * FROM povrsina";

        List<Povrsina> povrsine = jdbcTemplate.query(sql, (resultSet, i) -> {
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

        return povrsine;
    }

    @Override
    public int insert(Povrsina povrsina) {
        final String sql = "INSERT INTO povrsina (Oznaka, Naziv, VrstaPoda, ProjekatZaGradjevinskuDozvoluId, VrstaPovrsineId, ProstorijaNaziv, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, povrsina.getOznaka());
                statement.setString(2, povrsina.getNaziv());
                statement.setString(3, povrsina.getVrstaPoda());
                statement.setInt(4, povrsina.getProjekatZaGradjevinskuDozvoluId());
                statement.setInt(5, povrsina.getVrstaPovrsineId());
                statement.setString(6, povrsina.getProstorijaNaziv());
                statement.setInt(7, povrsina.getStatus().ordinal());
                return statement;
            }
        }, holder);

        return holder.getKey().intValue();
    }

    @Override
    public int update(Integer id, Povrsina povrsina) {
        final String sql = "UPDATE povrsina SET Oznaka = ?, Naziv = ?, VrstaPoda = ?, ProjekatZaGradjevinskuDozvoluId = ?, VrstaPovrsineId = ?, ProstorijaNaziv = ?, Status = ? WHERE Id = ?";

        jdbcTemplate.update(sql, povrsina.getOznaka(), povrsina.getNaziv(), povrsina.getVrstaPoda(), povrsina.getProjekatZaGradjevinskuDozvoluId(), povrsina.getVrstaPovrsineId(), povrsina.getProstorijaNaziv(), povrsina.getStatus().ordinal(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM povrsina WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}
