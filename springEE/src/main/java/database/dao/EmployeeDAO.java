package database.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import database.entities.Employee;

@Repository
public class EmployeeDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Employee> findAll() {
		
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		List result=session.createQuery("select t from Employee t").list();
		session.getTransaction().commit();
		return result;
	}
	
	public Employee createUser(String name) {
		Employee employee = new Employee();
		employee.setName(name);
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.persist(employee);
		session.getTransaction().commit();
		return employee;		
	}
	
	public void deleteUsers() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
//		List<Employee> resultList=session.createQuery("select t from Employee t",Employee.class).list();
		session.createQuery("delete from Employee t").executeUpdate();	
		session.getTransaction().commit();
	}
}
