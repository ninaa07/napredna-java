package com.naprednajava.NaprednaJava.repositories.Prostorija;

import com.naprednajava.NaprednaJava.models.Prostorija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("prostorija")
public class ProstorijaRepository implements IProstorijaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProstorijaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Prostorija> getAll() {
        final String sql = "SELECT * FROM prostorija";

        List<Prostorija> prostorije = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String naziv = resultSet.getString("Naziv");
            Integer vrstaPovrsineId = resultSet.getInt("VrstaPovrsineId");
            return new Prostorija(id, naziv, vrstaPovrsineId);
        });

        return prostorije;
    }

    @Override
    public int insert(Prostorija prostorija) {
        final String sql = "INSERT INTO prostorija (Naziv, VrstaPovrsineId) VALUES (?, ?)";

        jdbcTemplate.update(sql, prostorija.getNaziv(), prostorija.getVrstaPovrsineId());

        return 0;
    }

    @Override
    public int update(Integer id, Prostorija prostorija) {
        final String sql = "UPDATE prostorija SET Naziv = ?, VrstaPovrsineId = ? WHERE Id = ?";

        jdbcTemplate.update(sql, prostorija.getNaziv(), prostorija.getVrstaPovrsineId(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM prostorija WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}