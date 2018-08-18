package trng.imcs.projects.maven.project;

import java.util.List;

public class EmployeeArrayOperations {

	EmployeeUtil employeeUtil = new EmployeeUtil();

	public void addEmployee(Employee employee) {
		employeeUtil.addEmployee(employee);
	}

	public void showAllEmployees() {
		employeeUtil.showAllEmployees();
	}

	public Employee getEmployee(int empId) {
		return employeeUtil.getEmployee(empId);
	}

	public double calculateHRA(int empId) {
		return employeeUtil.calculateHRA(getEmployee(empId));
	}

	public double calculateGrossSalary(int empId) {
		return employeeUtil.calculateGrossSalary(getEmployee(empId));
	}

	public void deleteEmployee(int empId) {
		employeeUtil.deleteEmployee(empId);

	}

}
