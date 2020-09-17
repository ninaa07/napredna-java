package com.naprednajava.NaprednaJava.services;

import com.naprednajava.NaprednaJava.models.Person;
import com.naprednajava.NaprednaJava.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("PersonService")
public class PersonService implements IPersonService{

    private final IPersonRepository personRepository;

    @Autowired
    public PersonService(@Qualifier("postgres") IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public int addPerson(Person person) {
        return personRepository.insertPerson(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.selectAllPeople();
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return personRepository.selectPersonById(id);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return personRepository.updatePersonById(id, person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return personRepository.deletePersonById(id);
    }
}
