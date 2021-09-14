package in.nit.surya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_tab")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "eid")
	private Integer id;
	@Column(name = "ename")
	private String empName;
	@Column(name = "esal")
	private Double empSal;
	@Column(name = "edept")
	private String empDept;
	@Column(name = "eaddr")
	private String empAddr;
}
