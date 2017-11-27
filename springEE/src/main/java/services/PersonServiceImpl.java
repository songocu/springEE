package services;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import database.dao.PersonDao;
import database.entities.Person;
 
 
@Service("personService")
public class PersonServiceImpl implements PersonService {
 
    @Autowired
    PersonDao personDao;
 
    public Person addPerson(Person person) {
        personDao.addPerson(person);
        return person;
    }
 
    public void editPerson(Person person, int personId) {
        personDao.editPerson(person, personId);
    }
 
    public void deletePerson() {
        personDao.deletePerson();
    }
 
    public Person find(int personId) {
        return personDao.find(personId);
    }
 
    public List < Person > findAll() {
        return personDao.findAll();
    }
}