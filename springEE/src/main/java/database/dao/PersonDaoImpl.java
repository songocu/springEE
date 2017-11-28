package database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import database.entities.Person;

@Repository
@Qualifier("personDao")
public class PersonDaoImpl implements PersonDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	@Autowired
//	SessionFactory factory;

	public Person addPerson(Person person) {
		//increasing of id is set from database, setting done when database was created with:
		//create table person(personid serial primary key, firstname varchar(50),lastname varchar(50),age integer);
		jdbcTemplate.update("INSERT INTO person (firstname, lastname, age) VALUES (?, ?, ?)",
				person.getFirstName(), person.getLastName(), person.getAge());
		System.out.println("Person Added!!");
		return person;
	}

	public void editPerson(Person person, int personId) {
		jdbcTemplate.update("UPDATE person SET firstname = ? , lastname = ? , age = ? WHERE personid = ? ",
				person.getFirstName(), person.getLastName(), person.getAge(), personId);
		System.out.println("Person Updated!!");
	}

	public void deletePerson() {
		jdbcTemplate.update("DELETE from person");
		System.out.println("All Person Deleted!!");
	}

	public Person find(int personId) {
		Person person = (Person) jdbcTemplate.queryForObject("SELECT * FROM person where personid = ? ",
				new Object[] { personId }, new BeanPropertyRowMapper(Person.class));

		return person;
	}

	public List<Person> findAll() {
//		Person person=new Person();
//		person.setFirstName("a");
//		person.setLastName("b");
//		factory.getCurrentSession().save(person);
		List<Person> persons = jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper(Person.class));
		return persons;
	}
}