package database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import database.entities.Employee;

@Repository
public class EmployeeDAO extends AbstractSessionFactory{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Employee> findAll() {
		return getCurrentSession().createQuery("select t from Employee t",Employee.class).list();
	}
	
	public Employee createUser(String name) {
		Employee employee = new Employee();
		employee.setName(name);
		getCurrentSession().persist(employee);
		return employee;		
	}
	
	public Employee createUserTransactional(String name) {
		Employee employee = new Employee();
		employee.setName(name);
		getCurrentSession().persist(employee);
		return employee;		
	}
	
	public void deleteUsers() {
		getCurrentSession().createQuery("delete from Employee t").executeUpdate();	
	}
}
