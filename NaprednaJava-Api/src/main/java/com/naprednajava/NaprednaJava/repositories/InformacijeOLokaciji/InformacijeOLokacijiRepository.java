package com.naprednajava.NaprednaJava.repositories.InformacijeOLokaciji;

import com.naprednajava.NaprednaJava.models.InformacijeOLokaciji;
import com.naprednajava.NaprednaJava.models.LokacijskaDozvola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("informacijeOLokaciji")
public class InformacijeOLokacijiRepository implements IInformacijeOLokacijiRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InformacijeOLokacijiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<InformacijeOLokaciji> getAll() {
        final String sql = "SELECT * FROM informacijeolokaciji";

        List<InformacijeOLokaciji> informacijeOLokaciji = jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = resultSet.getInt("Id");
            String naziv = resultSet.getString("Naziv");
            Date datumIzdavanja = resultSet.getDate("DatumIzdavanja");
            String namenaZemljista = resultSet.getString("NamenaZemljista");
            String zona = resultSet.getString("Zona");
            return new InformacijeOLokaciji(id, naziv, datumIzdavanja, namenaZemljista, zona);
        });

        for (InformacijeOLokaciji iol : informacijeOLokaciji) {
            final String sql2 = "SELECT * FROM lokacijskadozvola WHERE InformacijeOLokacijiId = " + iol.getId() + " ";

            List<LokacijskaDozvola> lokacijskeDozvole = jdbcTemplate.query(sql2, (resultSet, i) -> {
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

            iol.setLokacijskeDozvole(lokacijskeDozvole);
        }

        return informacijeOLokaciji;
    }

    @Override
    public int insert(InformacijeOLokaciji informacijeOLokaciji) {
        final String sql = "INSERT INTO informacijeolokaciji (Naziv, DatumIzdavanja, NamenaZemljista, Zona) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, informacijeOLokaciji.getNaziv(), informacijeOLokaciji.getDatumIzdavanja(), informacijeOLokaciji.getNamenaZemljista(), informacijeOLokaciji.getZona());

        return 0;
    }

    @Override
    public int update(Integer id, InformacijeOLokaciji informacijeOLokaciji) {
        final String sql = "UPDATE informacijeolokaciji SET Naziv = ?, DatumIzdavanja = ?, NamenaZemljista = ?, Zona = ? WHERE Id = ?";

        jdbcTemplate.update(sql, informacijeOLokaciji.getNaziv(), informacijeOLokaciji.getDatumIzdavanja(), informacijeOLokaciji.getNamenaZemljista(), informacijeOLokaciji.getZona(), id);

        return 0;
    }

    @Override
    public int delete(Integer id) {
        final String sql = "DELETE FROM informacijeolokaciji WHERE Id = ?";

        jdbcTemplate.update(sql, id);

        return 0;
    }
}
