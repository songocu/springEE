package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView service() {
		ModelAndView model = new ModelAndView("employees");
		model.addObject("items", employeeService.findAll());
		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createUser() {
		employeeService.createEmployee();
		ModelAndView model = new ModelAndView("create");
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUsers() {
		employeeService.deleteUsers();
		ModelAndView model = new ModelAndView("delete");
		return model;
	}
}