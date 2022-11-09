package edu.baylor.cs.se.hibernate.services;

import edu.baylor.cs.se.hibernate.State;
import edu.baylor.cs.se.hibernate.model.Contest;
import edu.baylor.cs.se.hibernate.model.Person;
import edu.baylor.cs.se.hibernate.model.Team;
import edu.baylor.cs.se.hibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getAllPerson()
    {
        return personRepository.findAll();
    }

    public Person personById(@PathVariable("id") Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        else return null;
    }
}

