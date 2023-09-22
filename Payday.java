import java.util.Scanner;
public class Payday {
	public static void main(String[] args) {
		//welcome text
		System.out.println("**************************************************");
		System.out.println("Payday V1.0");
		System.out.println("**************************************************");
		
		//inputs that the users are putting in
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter hours worked:");
		double hoursWorked = sc.nextDouble();
		System.out.print("Enter hourly pay rate: ");
		double payRate = sc.nextDouble();
		System.out.print("Are you a union member (y or n)? ");
		String unionMember = sc.next();
		System.out.print("What percentage do you want to withould for your medical savings account? ");
		double percentWithold = sc.nextDouble();
		
		
		//Calculations 
		double grossPay = hoursWorked * payRate;
		double unionDue = 0;
		if (unionMember.equals("y")) {
			unionDue = 0.05 * grossPay;
		} else if (unionMember.equals("n")) {
			unionDue = 0;
		}
		double medicalDeduction = (percentWithold/ 100) * grossPay; 
		double incidentPay = (Math.random() * 400) - 200;
		double adjustedGrossPay = grossPay + incidentPay - unionDue - medicalDeduction;
		double taxes = 0;
		if (adjustedGrossPay >= 2500) {
			taxes = 0.20 * adjustedGrossPay;
		}else if (adjustedGrossPay >= 1500) {
			taxes = 0.15 * adjustedGrossPay;
		}else if (adjustedGrossPay >= 500) {
			taxes = 0.10 * adjustedGrossPay;
		} else {
			taxes = 0.05 * adjustedGrossPay;
		}
		double netPay = adjustedGrossPay - taxes;
		
		
		//Print statements
		System.out.println("---------PAYCHECK---------");
		System.out.printf("Gross Pay 	$ %.2f%n", grossPay);
		System.out.printf("Union Dues 	$ %.2f%n", unionDue);
		System.out.printf("Med Deduction   $ %.2f%n", medicalDeduction);
		System.out.printf("Incident Pay    $ %.2f%n", incidentPay);
		System.out.printf("Taxes 		$ %.2f%n", taxes);
		System.out.printf("Net Pay 	$ %.2f%n", netPay);
		System.out.println("--------------------------");
		System.out.println("Prepared for " + name );
		System.out.println("Thank you for using this program.");
		
	}
}
