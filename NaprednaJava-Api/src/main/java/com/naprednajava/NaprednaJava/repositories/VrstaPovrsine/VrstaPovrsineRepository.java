package com.naprednajava.NaprednaJava.repositories.VrstaPovrsine;

import com.naprednajava.NaprednaJava.models.Prostorija;
import com.naprednajava.NaprednaJava.models.VrstaPovrsine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vrstaPovrsine")
public class VrstaPovrsineRepository implements IVrstaPovrsineRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VrstaPovrsineRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<VrstaPovrsine> getAll() {
        final String sql = "SELECT * FROM vrstapovrsine";

        List<VrstaPovrsine> vrstePovrsina = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String naziv = resultSet.getString("Naziv");
            return new VrstaPovrsine(id, naziv);
        });

        for (VrstaPovrsine vp : vrstePovrsina) {
            final String sql2 = "SELECT * FROM prostorija WHERE VrstaPovrsineId = " + vp.getId() + " ";

            List<Prostorija> prostorije = jdbcTemplate.query(sql2, (resultSet, i) -> {
                Integer id = resultSet.getInt("Id");
                String naziv = resultSet.getString("Naziv");
                Integer vrstaPovrsineId = resultSet.getInt("VrstaPovrsineId");
                return new Prostorija(id, naziv, vrstaPovrsineId);
            });

            vp.setProstorije(prostorije);
        }

        return vrstePovrsina;
    }

    @Override
    public int insert(VrstaPovrsine vrstaPovrsine) {
        final String sql = "INSERT INTO vrstapovrsine (Naziv) VALUES (?)";

        jdbcTemplate.update(sql, vrstaPovrsine.getNaziv());

        return 0;
    }

    @Override
    public int update(Integer id, VrstaPovrsine vrstaPovrsine) {
        final String sql = "UPDATE vrstapovrsine SET Naziv = ? WHERE Id = ?";

        jdbcTemplate.update(sql, vrstaPovrsine.getNaziv(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM vrstapovrsine WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}