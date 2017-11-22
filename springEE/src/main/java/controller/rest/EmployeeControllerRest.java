package controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import database.entities.Employee;
import services.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeControllerRest {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> service() {
		return employeeService.findAll();
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public Employee createUser() {
		return employeeService.createEmployee();
	}
	
	@RequestMapping(value = "/createtransactional", method = RequestMethod.GET)
	public Employee createUserTransactional() {
		return employeeService.createEmployeeTransactional();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUsers() {
		employeeService.deleteUsers();
		return "Users deleted!";
	}
}