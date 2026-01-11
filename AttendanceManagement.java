import java.util.*;

class Attendance
{
    private String month;
    private int daysInMonth, totalDaysWorked, totalDaysAbsent, lopDays;

    Attendance(String month, int daysInMonth, int totalDaysWorked, int totalDaysAbsent, int lopDays)
    {
        this.month = month;
        this.daysInMonth = daysInMonth;
        this.totalDaysWorked = totalDaysWorked;
        this.totalDaysAbsent = totalDaysAbsent;
        this.lopDays = lopDays;
    }

    // Getter methods
    public String getMonth() { 
	return month;
    }
    public int getDaysInMonth() { 
	return daysInMonth; 
    }
    public int getTotalDaysWorked() { 
	return totalDaysWorked;
    }
    public int getTotalDaysAbsent() { 
	return totalDaysAbsent; 
    }
    public int getLopDays() { 
	return lopDays; 
    }
}

class AttendanceManagement
{
    EmployeeManagement employeeManager; // reference to EmployeeManagement class
    Scanner input = new Scanner(System.in);

    AttendanceManagement(EmployeeManagement employeeManager)
    {
        this.employeeManager = employeeManager;
    }
   
   // method to mark attendance for all employees at once
   public void markAttendance() 
   {
    for (Employee e : employeeManager.getEmployees())
     {
        try {
            System.out.println("Marking attendance for Employee ID: " + e.getEmployeeId());
            System.out.print("Enter Month in words: ");
            String month = input.next();
            System.out.print("Enter Total Days in Month: ");
            int daysInMonth = input.nextInt();
            System.out.print("Enter Total Days Worked: ");
            int totalDaysWorked = input.nextInt();
            System.out.print("Enter Total Absent Days: ");
            int totalDaysAbsent = input.nextInt();
            System.out.print("Enter Total LOP Days: ");
            int lopDays = input.nextInt();
            input.nextLine();

	    // throws an exception if any one of the attendance inputs are negative
            if (daysInMonth < 0 || totalDaysWorked < 0 || totalDaysAbsent < 0 || lopDays < 0)
	    {
                throw new InvalidInputException("Error: Days cannot be negative");
            }

           // adding it to arrayList
           e.getAttendanceRecords().add(new Attendance(month, daysInMonth, totalDaysWorked, totalDaysAbsent, lopDays));
            System.out.println("Attendance marked for " +  e.getEmployeeId());
        } 
        catch (InvalidInputException i) 
	{
            System.out.println(i.print());
	    break;
        }    
	}
    	System.out.println("Attendance marked for all Employees ");
}

       
   // method to display attendance based on employeeId
    public void displayAttendance()
    {
        System.out.print("Enter Employee ID: ");
        String empId = input.next();
        for (Employee e : employeeManager.getEmployees())
        {
            if (e.getEmployeeId().equals(empId))
           {
               System.out.println("Attendance Records for Employee ID: " + empId);
               for (Attendance a : e.getAttendanceRecords())
	       {
                    System.out.println("Month: " + a.getMonth());
                    System.out.println("Total Days in Month: " + a.getDaysInMonth());
                    System.out.println("Total Days Worked: " + a.getTotalDaysWorked());
                    System.out.println("Total Days Absent: " + a.getTotalDaysAbsent());
                    System.out.println("LOP Days: " + a.getLopDays());
                }
                return;
            }
        }
        System.out.println("Employee not found");
    }
}


