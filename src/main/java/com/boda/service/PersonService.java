package com.boda.service;

import com.boda.entity.Person;
import com.boda.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id#" + id));
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(long id, Person person) {
        Person personTarget = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id#" + id));
        personTarget.setFirstName(person.getFirstName());
        personTarget.setLastName(person.getLastName());
        personTarget.setAge(person.getAge());

        return personRepository.update(personTarget);
    }

    public void delete(long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id#" + id));
        personRepository.delete(person);
    }
}
