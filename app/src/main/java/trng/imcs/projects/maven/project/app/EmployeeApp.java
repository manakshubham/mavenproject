package trng.imcs.projects.maven.project.app;

import java.util.Scanner;

import trng.imcs.projects.maven.project.Employee;
import trng.imcs.projects.maven.project.EmployeeArrayOperations;
import trng.imcs.projects.maven.project.EmployeeUtil;
import trng.imcs.projects.maven.project.enums.Gender;
import trng.imcs.projects.maven.project.enums.JobType;
import trng.imcs.projects.maven.project.enums.Menu;

public class EmployeeApp {

	public static void main(String[] args) {

		int numberOfEmployees;
		int choice;
		int empId;
		int allowedEmployeesCount;
		Menu menu;

		EmployeeArrayOperations employeeArrayOperations = new EmployeeArrayOperations();
		EmployeeUtil employeeUtil = new EmployeeUtil();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Maximum Limit of Employees to add? ");
		allowedEmployeesCount = scanner.nextInt();
		System.out.print("How many Employees do you wish to create? ");
		numberOfEmployees = scanner.nextInt();

		boolean checkCount = employeeUtil.checkCount(allowedEmployeesCount, numberOfEmployees);
		if (checkCount == true) {
			do {
				System.out.print(
						"\n||| Menu|||" + "\n 1. Create Employee" + "\n 2. View Employee" + "\n 3. View All Employees"
								+ "\n 4. Update Employee" + "\n 5. Delete Employee" + "\n 6. Calculate HRA"
								+ "\n 7. Calculate Gross Salary" + "\n 8. Exit" + "\n Select a choice: ");

				choice = scanner.nextInt();
				menu = Menu.getMenuByValue(choice);

				switch (menu) {
				case CREATEEMPLOYEE:
					for (int i = 0; i < numberOfEmployees; i++) {
						System.out.print("Enter Employee ID: ");
						int id = scanner.nextInt();
						System.out.print("Enter Employee First Name: ");
						String firstName = scanner.next();
						System.out.print("Enter Employee Last Name: ");
						String lastName = scanner.next();
						System.out.print("Enter Employee Salary: ");
						double salary = scanner.nextDouble();

						System.out.println("Enter Employee Gender: ");
						System.out.println("1 for " + Gender.MALE);
						System.out.println("2 for " + Gender.FEMALE);
						int g = scanner.nextInt();

						Gender gender = null;
						if (g == 1) {
							gender = Gender.MALE;
						} else if (g == 2) {
							gender = Gender.FEMALE;
						}

						System.out.println("Enter Employee Job Type: ");
						System.out.println("1 for " + JobType.PERMANENT);
						System.out.println("2 for " + JobType.CONTRACT);
						int jt = scanner.nextInt();

						JobType jobType = null;
						if (jt == 1) {
							jobType = JobType.PERMANENT;
						} else if (jt == 2) {
							jobType = JobType.CONTRACT;
						}
						Employee employee = new Employee(id, firstName, lastName, salary, gender, jobType);
						employeeArrayOperations.addEmployee(employee);
					}
					break;

				case VIEWEMPLOYEE:
					System.out.print("Enter Employee id:");
					empId = scanner.nextInt();
					System.out.println(employeeArrayOperations.getEmployee(empId));
					break;

				case VIEWALLEMPLOYEES:
					employeeArrayOperations.showAllEmployees();

					break;

				case UPDATEEMPLOYEE:

					int updateChoice;

					System.out.print("Enter Employee id:");
					empId = scanner.nextInt();
					Employee employee = employeeArrayOperations.getEmployee(empId);
					System.out.println(employee);

					do {
						System.out.print("What do you want to update? " + "\n Enter 1 for First Name."
								+ "\n Enter 2 for Last Name." + "\n Enter 3 for Salary" + "\n Enter 4 for Gender"
								+ "\n Enter 5 for Job Type" + "\n Enter 6 for Exit: \n");
						updateChoice = scanner.nextInt();

						System.out.println("Employee ID: " + employee.getId());
						if (updateChoice == 1) {
							System.out.print("Enter Employee First Name: ");
							employee.setFirstName(scanner.next());
							System.out.println("First Name Updated");
						} else if (updateChoice == 2) {
							System.out.println("Enter Employee Last Name: ");
							employee.setLastName(scanner.next());
							System.out.println("Last Name Updated");
						} else if (updateChoice == 3) {
							System.out.print("Enter Employee Salary: ");
							employee.setSalary(scanner.nextDouble());
							System.out.println("Salary Updated");
						} else if (updateChoice == 4) {
							System.out.println("Enter Employee Gender: ");
							System.out.println("1." + Gender.MALE);
							System.out.println("2." + Gender.FEMALE);
							int g = scanner.nextInt();
							if (g == 1) {
								employee.setGender(Gender.MALE);
								System.out.println("Gender set to Male");
							} else if (g == 2) {
								employee.setGender(Gender.FEMALE);
								System.out.println("Gender set to Female");
							}
						} else if (updateChoice == 5) {
							System.out.println("Enter Employee Job Type: ");
							System.out.println("1." + JobType.PERMANENT);
							System.out.println("2." + JobType.CONTRACT);
							int jt = scanner.nextInt();
							if (jt == 1) {
								employee.setJobType(JobType.PERMANENT);
								System.out.println("Job Type set to Permanent");
							} else if (jt == 2) {
								employee.setJobType(JobType.CONTRACT);
								System.out.println("Job Type set to Contract");
							}
						}
					} while (!(updateChoice == 6));
					break;

				case DELETEEMPLOYEE:
					System.out.print("Enter Employee id you want to delete: ");
					empId = scanner.nextInt();
					employeeArrayOperations.deleteEmployee(empId);
					break;

				case CALCULATEHRA:
					System.out.print("Enter Employee id:");
					empId = scanner.nextInt();
					double hra = employeeArrayOperations.calculateHRA(empId);
					System.out.println("HRA of Employee id " + empId + " is " + hra);
					break;

				case CALCUALTEGROSSSALARY:
					System.out.print("Enter Employee id:");
					empId = scanner.nextInt();
					double grossSalary = employeeArrayOperations.calculateGrossSalary(empId);
					System.out.println("Gross Salary of Employee id " + empId + " is " + grossSalary);
					break;

				case EXIT:
					break;
				default:
					System.out.println("Wrong Choice!! ;-(");
					break;
				}
			} while (menu.getValue() != 8);
		} else {
			System.out.println("You can only add " + allowedEmployeesCount + " Employees");
		}
	}
}
