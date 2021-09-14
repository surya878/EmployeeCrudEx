package in.nit.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.surya.model.Employee;
import in.nit.surya.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//HAS-A
	@Autowired
	private IEmployeeService service;
	
	public EmployeeController() {
		System.out.println("Employee-0 param Contructor");
	}
	/**
	 * If End User enters/register in address
	 * this method is called and loads
	 * EmployeeRegister.html page from /template folder
	 */
	@RequestMapping( value = "/register",method = RequestMethod.GET)
	public String EmpRegister() {
		return "EmployeeRegister";
	}
	
	/**
	 * On form submit(/save+POST) ,Read data as Object using
	 * @ModelAttribute
	 * call service layer wit object,read ID back
	 * create Model memory,send Message to UI
	 * Return back to EmployeeRegister.html
	 */
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee,
			Model model)
	{
		System.out.println(model.getClass().getName());
		Integer id=service.saveEmployee(employee);
		String message="Employee+'"+id+"' Created";
		model.addAttribute("message", message);
		return "EmployeeRegister";
	}
	/**
	 * Fetch data from DB using service
	 * send Data to UI using Model
	 * Return to EmployeeData.html
	 */
	@GetMapping("/all")
	public String viewAllEmployees(Model model) {
			List<Employee> list=service.getAllEmployees();
			model.addAttribute("list", list);
			return "EmployeeData";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(
			@RequestParam Integer id,
			Model model
			)
	{
	
		//call service
		service.deleteEmployee(id);
		//onew success Message
		String message="Employee  '"+id+"' Deleted";
		model.addAttribute("message",message);
		
		//get latest data
		List<Employee> list=service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	@GetMapping("/edit")
	public String showEmployeeEdit(
			@RequestParam Integer id,
			Model model
			) {
			//load object from DB
		Employee employee=service.getOneEmployee(id);
		//send Object to UI
		model.addAttribute("employee", employee);
		//return to view page
		return "EmployeeEdit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(
			@ModelAttribute Employee employee
			)
			{	
			service.updateEmployee(employee);
		return "redirect:all";
	}
}
