package dbunittest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;


import database.entities.Person;
import services.PersonServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PersonServiceTest extends TransactionalTestsSetup{

	@Autowired
	private PersonServiceImpl personService;

	@Test
	@DatabaseSetup("sampleData.xml")
	public void testFind() throws Exception {
		List<Person> personList = this.personService.findAll();
		System.out.println("Persons found: " + "\n" + personList);
		assertEquals(2, personList.size());
	}

	@Test
	@DatabaseSetup("sampleData.xml")
	@ExpectedDatabase(value="expectedData.xml", assertionMode=com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT)
	public void testRemove() throws Exception {
		List<Person> personList = this.personService.findAll();
		System.out.println("Persons found: " + "\n" + personList);
		this.personService.removePerson(1);
		personList = this.personService.findAll();
		System.out.println("Persons found: " + "\n" + personList);
	}

}
