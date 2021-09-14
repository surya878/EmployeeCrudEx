package in.nit.surya.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.surya.model.Employee;
import in.nit.surya.repository.EmployeeRepository;
import in.nit.surya.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	// HAS-A
	@Autowired
	private EmployeeRepository repo;

	public Integer saveEmployee(Employee employee) {
		employee = repo.save(employee);
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list=repo.findAll();
		return list;
	}
	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt=repo.findById(id);
		if(opt.isPresent()) {
			Employee e=opt.get();
			return e;
		}
		//TODO: else trow exception Employee not found
		return null;
	}
	@Override
	public void updateEmployee(Employee e) {
		repo.save(e);
		
	}
	
}
