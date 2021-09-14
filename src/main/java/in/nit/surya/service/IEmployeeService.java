package in.nit.surya.service;

import java.util.List;

import in.nit.surya.model.Employee;

public interface IEmployeeService {

	Integer	saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	void deleteEmployee(Integer id);
	Employee getOneEmployee(Integer id);
	void updateEmployee(Employee e);
}
