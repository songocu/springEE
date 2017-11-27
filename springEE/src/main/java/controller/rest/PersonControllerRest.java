package controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import database.entities.Employee;
import database.entities.Person;
import services.EmployeeService;
import services.PersonService;

@RestController
@RequestMapping("/rest")
public class PersonControllerRest {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/listperson", method = RequestMethod.GET)
	public List<Person> service() {
		return personService.findAll();
	}

	@RequestMapping(value = "/createperson", method = RequestMethod.GET)
	public Person createUser() {
		Person person = new Person();
		person.setAge(20);
		person.setFirstName("Gigel");
		person.setLastName("Coman");
		return personService.addPerson(person);
	}
	
	/*@RequestMapping(value = "/createtransactional", method = RequestMethod.GET)
	public Employee createUserTransactional() {
		return employeeService.createEmployeeTransactional();
	}*/
	
	@RequestMapping(value = "/deleteperson", method = RequestMethod.GET)
	public String deleteUsers() {
		personService.deletePerson();
		return "Persons deleted!";
	}
}