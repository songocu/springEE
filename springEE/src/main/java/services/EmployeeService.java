package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.EmployeeDAO;
import database.entities.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}
	
	public Employee createEmployee() {
		return employeeDAO.createUser("Gigel");
	}
	
	public void deleteUsers(){
		employeeDAO.deleteUsers();
	}
	
}
