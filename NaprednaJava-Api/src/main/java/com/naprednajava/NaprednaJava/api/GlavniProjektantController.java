//package com.naprednajava.NaprednaJava.api;
//
//
//import com.naprednajava.NaprednaJava.models.Person;
//import com.naprednajava.NaprednaJava.services.IPersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//import java.util.UUID;
//
//@RequestMapping("api/v1/glavniprojektant")
//@RestController
//public class GlavniProjektantController {
//
//    private final IPersonService personService;
//
//    @Autowired
//    public PersonController(@Qualifier("PersonService") IPersonService personService) {
//        this.personService = personService;
//    }
//
//    @GetMapping
//    public List<Person> getAllPeople() {
//        return personService.getAllPeople();
//    }
//
//    @GetMapping(path = "{id}")
//    public Person getPersonById(@PathVariable("id") UUID id) {
//        return personService.getPersonById(id).orElse(null);
//    }
//
//    @PostMapping
//    public void addPerson(@Valid @NotNull @RequestBody Person person) {
//        personService.addPerson(person);
//    }
//
//    @PutMapping(path = "{id}")
//    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person) {
//        personService.updatePersonById(id, person);
//    }
//
//    @DeleteMapping(path = "{id}")
//    public void deletePersonById(@PathVariable("id") UUID id) {
//        personService.deletePersonById(id);
//    }
//}
