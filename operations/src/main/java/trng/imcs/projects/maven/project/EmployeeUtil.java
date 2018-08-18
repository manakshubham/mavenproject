package trng.imcs.projects.maven.project;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtil {

	List<Employee> employees = new ArrayList<>();
	Employee employees2[] = new Employee[20];
	private static int count = 0;

	public boolean checkCount(int allowedEmployeesCount, int numberOfEmployees) {
		if (allowedEmployeesCount < numberOfEmployees) {
			return false;
		} else {
			return true;
		}
	}

	public void addEmployee(Employee employee) {
		employees2[count] = employee;
		count++;
	}

	public Employee getEmployee(int empId) {

		for (Employee employee : employees) {
			if (employee.getId() == empId) {
				return employee;
			}
		}
		return null;
	}

	public void showAllEmployees() {
		for (Employee e : employees2) {
			System.out.println(e);
		}
	}

	public double calculateHRA(Employee employee) {
		employee.setHra(employee.getSalary() * 1.1);
		return employee.getHra();
	}

	public double calculateGrossSalary(Employee employee) {
		employee.setGrossSalary(employee.getSalary() + calculateHRA(employee));
		return employee.getGrossSalary();
	}

	public void deleteEmployee(int empId) {
		Employee employee = getEmployee(empId);
		if (employee == null) {
			System.out.println("Employee does not exist");
		} else {
			employees.remove(employee);
			System.out.println("Employee Deleted Successfully");
		}
	}

}
