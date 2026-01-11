import java.util.*;

class PayrollCalc
{
    static double ctc = 50000;
    double basic, hra, conveyance, medical, special, pf, pt, grossSalary, netSalary;
    EmployeeManagement employeeManager;

   PayrollCalc(EmployeeManagement employeeManager)
   {
	this.employeeManager = employeeManager;
   }

   // method to calculate payslip based on employeeId and attendance records of that employeeId
    public void calculateSalary() 
    {
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter Employee ID: ");
    	String empId = input.next();
    
    	for (Employee e : employeeManager.getEmployees()) 
	{
        	if (e.getEmployeeId().equals(empId))
		{
            		if (!e.getAttendanceRecords().isEmpty())
			{
                		System.out.print("Enter month in words: ");
                		String monthInput = input.next();                
                		boolean found = false;
                		int daysInMonth = 0, totalDaysWorked = 0, lopDays = 0;

                		// loop to check if attendance exists
                		for (Attendance a : e.getAttendanceRecords())
				{
                    			if (a.getMonth().equals(monthInput)) 
					{  
                        			found = true;
                        			 daysInMonth = a.getDaysInMonth();
                            			  totalDaysWorked = a.getTotalDaysWorked();
                            			  lopDays = a.getLopDays();
                        			break;  
                    			}
                		}
			       // calculation of wageslip
                	       if (found) 
				{
				// if the employee has'nt took any leave
                    		   if (lopDays == 0) {
                        		basic = 0.5 * ctc;
                    		   } 
				   else {
					// if the employee has taken leaves, loss of pay is calculated accordingly for that month
                        		double lopCalc = (ctc / daysInMonth) * totalDaysWorked;
                        		basic = 0.5 * lopCalc;
                    		   }

                    		hra = 0.5 * basic;
                    		conveyance = 1600;
                    		medical = 4342;
                    		special = 2750;
                    		pf = 3600;
                    		pt = 208;
                    		grossSalary = basic + hra + conveyance + medical + special;
                    		netSalary = grossSalary - (pf + pt);
                    		displaySalary(e);
               		 } 
		else {
                    System.out.println("No attendance record found for " + monthInput);
                }
            } 
	else {
                System.out.println("No attendance records found for this employee.");
            }
            break;
        }
    }
}


   // method to display a payslip for the given employeeId
    public void displaySalary(Employee e)
    {
    System.out.println("                                              Colan InfoTech Pvt. Ltd.");
    System.out.println("           Kosmo one, Tower-B 4th floor, 3rd Main Road, Ambattur Industrial Estate, Chennai - 600058");    
    System.out.println("                                                   WAGE SLIP");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Employee ID                       : " + e.getEmployeeId());
    System.out.println("Employee Name                     : " + e.getEmployeeName());
    System.out.println("Date of Joining                   : " + e.getDateOfJoining());
    System.out.println("Designation                       : " + e.getDesignation());
    System.out.println("Department                        : " + e.getDepartment());

    System.out.println("------------------------------------------------------------------------");
    System.out.println("                                        EARINGS");
    System.out.println("Basic                             : " + String.format("%.2f", basic));
    System.out.println("HRA                               : " + String.format("%.2f", hra));
    System.out.println("Conveyance                        : " + String.format("%.2f", conveyance));
    System.out.println("Medical                           : " + String.format("%.2f", medical));
    System.out.println("Special Allowance                 : " + String.format("%.2f", special));
    System.out.println("  ");
    System.out.println("Total Earnings                    : " + String.format("%.2f", grossSalary) );
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("                                        DEDUCTIONS");
    System.out.println("PF                                : " + String.format("%.2f", pf));
    System.out.println("PT                                : " + String.format("%.2f", pt));
    System.out.println("  ");
    System.out.println("Total Deductions                  : " + (pf + pt));
    System.out.println("---------------------------------------------------------------------------");
    System.out.println("Net Salary   : " + String.format("%.2f", netSalary));
    System.out.println("  ");

    }
}


