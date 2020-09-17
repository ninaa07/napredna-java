//package com.naprednajava.NaprednaJava.repositories.GlavniProjektant;
//
//import com.naprednajava.NaprednaJava.models.GlavniProjektant;
//import com.naprednajava.NaprednaJava.models.IdejnoResenje;
//import com.naprednajava.NaprednaJava.models.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository("glavniProjektant")
//public class GlavniProjektantRepository implements IGlavniProjektantRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public GlavniProjektantRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public List<GlavniProjektant> selectAll() {
//        final String sql = "SELECT * FROM glavniProjektant";
//
//        List<GlavniProjektant> glavniProjektanti = jdbcTemplate.query(sql, (resultSet, i) -> {
//            UUID id = UUID.fromString(resultSet.getString("id"));
//            String imePrezime = resultSet.getString("imePrezime");
//            Long brojLicence = resultSet.getLong("brojLicence");
//            String zvanje = resultSet.getString("zvanje");
//            return new GlavniProjektant(id, imePrezime, brojLicence, zvanje);
//        });
//
//        final String sql2 = "SELECT * FROM glavniProjektant";
//
//        for (GlavniProjektant gp: glavniProjektanti) {
//
//        }
//
//        return people;
//    }
//
//    @Override
//    public Optional<Person> selectPersonById(UUID id) {
//        final String sql = "SELECT id, name FROM person WHERE id = ?";
//
//        Person person = jdbcTemplate.queryForObject(
//                sql,
//                new Object[]{id},
//                (resultSet, i) -> {
//                    UUID personId = UUID.fromString(resultSet.getString("id"));
//                    String name = resultSet.getString("name");
//                    return new Person(personId, name);
//                });
//
//        return Optional.ofNullable(person);
//    }
//
//    @Override
//    public int insertPerson(UUID id, Person person) {
//        final String sql = "INSERT INTO person (id, name) VALUES (?, ?)";
//
//        jdbcTemplate.update(sql, id, person.getName());
//
//        return 0;
//    }
//
//    @Override
//    public int updatePersonById(UUID id, Person person) {
//        final String sql = "UPDATE person SET name = ? WHERE id = ?";
//
//        jdbcTemplate.update(sql, person.getName(), id);
//
//        return 0;
//    }
//
//    @Override
//    public int deletePersonById(UUID id) {
//        final String sql = "DELETE FROM person WHERE id = ?";
//
//        jdbcTemplate.update(sql, id);
//
//        return 0;
//    }
//}
