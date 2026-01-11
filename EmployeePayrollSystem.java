//  cd D:\javaProject

import java.util.*;
public class EmployeePayrollSystem
{
    EmployeeManagement empManager = new EmployeeManagement();
    AttendanceManagement attendanceManager = new AttendanceManagement(empManager);
    PayrollCalc payrollCalc = new PayrollCalc(empManager);
    Scanner input = new Scanner(System.in);
    
   public void menuDisplay()
    {
        int choice;
        do
        {
            System.out.println("\nWelcome to Employee Payroll System");
            System.out.println("1. Admin");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice)
            {
                case 1:
                 	System.out.println("\n------ ADMIN LOGIN ------");
			System.out.print("Enter username: ");
			String username = input.nextLine();
			System.out.print("Enter password: ");
			String password = input.nextLine();
			if (username.equals("hrteam") && password.equals("12345")) 
			{
    				adminMenu(); // calls the method
			} 
			else 
			{
    				System.out.println("Incorrect username or password");
			}		
                    break;
                case 2:
                    employeeMenu(); // calls the method
                    break;
                case 3:
                    System.out.println("system exited");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice >=1 && choice <=3);
    }


    void adminMenu()
    {
        int choice;
        do
        {  
            System.out.println("---------------------------- ADMIN MENU ------------------------------");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Display Attendance");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice)
            {
                case 1:
                    empManager.addEmployee();
                    break;
                case 2:
                    empManager.displayEmployees();
                    break;
                case 3:
                    attendanceManager.markAttendance();
                    break;
                case 4:
                    attendanceManager.displayAttendance();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");    
            }
        }  while(choice >=1 && choice <=5);
    }


    void employeeMenu()
    {
        int choice;
        do
        {
            System.out.println("---------------------------- EMPLOYEE MENU ------------------------------");
            System.out.println("1. Display Attendance");
            System.out.println("2. Display Payslip");
            System.out.println("3. Back to Main Menu");
            System.out.println("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();    
            switch (choice)
            {
                case 1:
                    attendanceManager.displayAttendance();
                    break;
                case 2:
                    payrollCalc.calculateSalary();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice >=1 && choice <=3);        
    }

	// main method
	public static void main (String[]args)
	{
		EmployeePayrollSystem system = new EmployeePayrollSystem();
		system.menuDisplay();
	}
}

