package database.dao;
import java.util.List;

import database.entities.Person;

 
public interface PersonDao {
 
    public Person addPerson(Person person);
 
    public void editPerson(Person person, int personId);
 
    public void deletePerson();
 
    public Person find(int personId);
 
    public List < Person > findAll();
}