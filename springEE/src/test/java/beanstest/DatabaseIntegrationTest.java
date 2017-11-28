package beanstest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.jdbc.Sql;

import database.entities.Employee;
import services.EmployeeService;

import java.util.List;

@Sql({"/sql/testEmployees.sql"})// specify sql created data
@Component
public class DatabaseIntegrationTest extends TransactionalTestsSetup {

    @Autowired
    EmployeeService employeeService;

    // specify programmatically created data
    @Before
    public void before() {
        employeeService.createEmployee();
        employeeService.createEmployee();
        employeeService.createEmployee();
    }

    @Test
    public void testFindAll() {
        List<Employee> all = employeeService.findAll();
        Assert.assertEquals(6, all.size());
    }

}
