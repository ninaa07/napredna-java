//package com.naprednajava.NaprednaJava.repositories.GlavniProjektant;
//
//import com.naprednajava.NaprednaJava.models.GlavniProjektant;
//import com.naprednajava.NaprednaJava.models.Person;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//public interface IGlavniProjektantRepository {
//
//    List<GlavniProjektant> selectAll();
//
//    Optional<GlavniProjektant> selectById(UUID id);
//
//    int insert(UUID id, GlavniProjektant glavniProjektant);
//
//    default int insert(GlavniProjektant glavniProjektant) {
//        UUID id = UUID.randomUUID();
//        return insert(id, glavniProjektant);
//    }
//
//    int update(UUID id, GlavniProjektant glavniProjektant);
//
//    int delete(UUID id);
//}
