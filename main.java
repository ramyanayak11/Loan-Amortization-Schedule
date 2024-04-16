
/* 
Name: RAMYA NAYAK	
Date: April 20, 2022
*/

import java.util.Scanner;

public class main {

	// ---------- MAIN BEGINS HERE ----------
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		float loanAmt;
		int numYrs;
		float annualInterestRate;
		double monthlyPayment;
		double totalPayment;
		double i;
		int n;
		
		System.out.printf("Loan Amount: ");
		loanAmt = in.nextFloat();
		System.out.printf("Number of Years: ");
		numYrs = in.nextInt();
		System.out.printf("Annual Interest Rate: ");
		annualInterestRate = in.nextFloat();
		System.out.printf("\n");
		
		annualInterestRate = annualInterestRate / 100;
		i = annualInterestRate / 12;
		n = numYrs * 12;
		monthlyPayment = (loanAmt * i * Math.pow(i + 1, n)) / (Math.pow(i + 1, n) - 1);
		totalPayment = monthlyPayment * n;
		
		
		if (loanAmt < 500) {
			System.out.printf("\nNot a valid loan amount, please enter a value greater than 500.");
		}
		else {
			printPayments(loanAmt, monthlyPayment, totalPayment, i, n);
		}

	}
	
	// ---------- PRINTING METHOD ----------

	static void printPayments(float loanAmt, double monthlyPayment, double totalPayment, double i, int n) {
		double interest;
		double principal;
		double balance;
		int m;
		
		System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
		System.out.printf("Total Payment: %.2f\n\n", totalPayment);
		
		System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", "Payment#", "Interest", "Principal", "Balance");
		
		balance = loanAmt;
		for (m = 1; m <= n; ++m) {
			interest = i * balance;
			principal = monthlyPayment - interest;
			balance = Math.abs(balance - principal);	
			System.out.printf("%d\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n", m, interest, principal, balance);
		}
	}
	
}
