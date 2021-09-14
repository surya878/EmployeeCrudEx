package in.nit.surya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.surya.model.Employee;

public interface EmployeeRepository extends
		JpaRepository<Employee, Integer> {

}
