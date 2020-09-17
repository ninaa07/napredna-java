package com.naprednajava.NaprednaJava.services;

import com.naprednajava.NaprednaJava.models.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPersonService {

    int addPerson(Person person);

    List<Person> getAllPeople();

    Optional<Person> getPersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    int deletePersonById(UUID id);
}
