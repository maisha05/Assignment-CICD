package edu.baylor.cs.se.hibernate.controller;
import edu.baylor.cs.se.hibernate.model.Person;
import edu.baylor.cs.se.hibernate.services.PersonService;
import edu.baylor.cs.se.hibernate.services.SuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {this.personService = personService; }

    @PostMapping("/person")
    public ResponseEntity createPerson(@RequestBody Person person)
    {
        personService.createPerson(person);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/allpersons", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(){
        return new ResponseEntity(personService.getAllPerson(),HttpStatus.OK);
    }

    @GetMapping("person/{id}")
    public Person personById(@PathVariable("id") Long id) {
        return personService.personById(id);
    }
}
