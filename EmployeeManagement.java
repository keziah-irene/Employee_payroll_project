import java.util.*;

// exception handling class
class InvalidInputException extends Exception
{
    private String message;
    public InvalidInputException(String message)
    {
        this.message = message;
    }
    public String print()
    {
        return message;
    }
}

class Employee
{
    private String employeeId, employeeName, designation, department, dateOfJoining;
    private ArrayList<Attendance> attendanceRecords; // declaring Attendance class as an arraylist
    
    // constructor
    Employee(String employeeId, String employeeName, String designation, String department, String dateOfJoining)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.department = department;
        this.dateOfJoining = dateOfJoining;
        this.attendanceRecords = new ArrayList<>(); // initialising arraylist
    }

     // getter methods 
    public String getEmployeeId() {
        return employeeId;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getDateOfJoining() {
        return dateOfJoining;
    }

   public ArrayList<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }
}

class EmployeeManagement
{
    private ArrayList<Employee> employees; // declaring Employee class as an arraylist
    Scanner input = new Scanner(System.in);

    EmployeeManagement()
    {
        // initialising arraylist with 3 pre-existing employees
        employees = new ArrayList<>();
        employees.add(new Employee("E101", "Simon", "Associate", "Application Development", "01-01-2020"));
        employees.add(new Employee("E102", "Anthony", "Software Engineer", "Web Development", "15-06-2015"));
        employees.add(new Employee("E103", "Daphne", "Senior Analyst", "Business Analysis", "23-11-2010"));
     }

    // getter method for Employee arrayList
     public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // method to add new employees
    public void addEmployee()
    {
        try
        {
            System.out.println("---------------------------- ADDING NEW EMPLOYEE ------------------------------");
            System.out.print("Enter Employee ID: ");
            String employeeId = input.nextLine();
            for (Employee e : employees)
            {
                if (e.getEmployeeId().equals(employeeId))
                {
		    // throws an exception if the newly added employee id already exists in the arraylist
                    throw new InvalidInputException("Error: Employee ID already exists"); 
                }
            }
            System.out.print("Enter Name: ");
            String employeeName = input.nextLine();
            System.out.print("Enter Designation: ");
            String designation = input.nextLine();
            System.out.print("Enter Department: ");
            String department = input.nextLine();
            System.out.print("Enter Date of Joining(dd-mm-yyyy): ");
            String dateOfJoining = input.nextLine();

	    // adding it to employee arraylist
            employees.add(new Employee(employeeId, employeeName, designation, department, dateOfJoining));
            System.out.println("Employee added successfully");
        }
        catch(InvalidInputException e)
        {
            System.out.println(e.print());
        }
    }

    // method to display all employees at once
    public void displayEmployees()
    {
        System.out.println("---------------------------- EMPLOYEE LIST ------------------------------");
        for (Employee e : employees)
        {
            System.out.println("ID: " + e.getEmployeeId() + ", Name: " + e.getEmployeeName() + ", Designation: " + e.getDesignation() + ", Department: " + e.getDepartment() + ", Date of Joining: " + e.getDateOfJoining());
        }
    }
}


