
/**
 * 
 * @author Tim Tanzilli(LAB 030) and Daniel Zelo (LAB 022)
 * Tim github - Tansilly
 * Dan github - dzelo
 * 
 * This program will inquire input from the user about retirement plans which will then be
 * used with imported functions to determine the amount of money one would need to save monthly
 * and total in order to survive financially while retired.
 * 
 */

import java.util.Scanner; //importing the scanner

import org.apache.poi.ss.formula.functions.FinanceLib; //importing the functions that will determine Present Value and the PMT

public class LabOne {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// declaring variables types
		double r;
		double n;
		double y;
		double p;
		double f;
		boolean t;

		// Acquiring user input
		System.out.print("Years to work: ");
		double YTW = input.nextDouble();

		System.out.print("Annual Return: ");
		double AR1 = input.nextDouble();

		System.out.print("Years Retired: ");
		double YR = input.nextDouble();

		System.out.print("Second Annual Return: ");
		double AR2 = input.nextDouble();

		System.out.print("Required Income: ");
		double RI = input.nextDouble();

		System.out.print("Monthly SSI: ");
		double MS = input.nextDouble();

		// Assigning variables to be used with finance function
		double PV;
		// PARAMETER TESTING BETWEEN 0-3%
		if (AR2 >= 0 & AR2 <= .03) {
			r = (AR2 / 12);
		}
		else {
			System.out.println("Second Annual Return must be within 0 and 3 percent" );
			System.out.print("Second Annual Return: ");
			AR2 = input.nextDouble();
			r = (AR2 / 12);
		}
		n = (YR * 12);
		y = (RI - MS);
		f = 0;
		t = false;
		PV = FinanceLib.pv(r, n, y, f, t);

		System.out.printf("What you need saved = $%,.2f%n", PV); // formatted to
																	// two
																	// decimals
																	// to
																	// represent
																	// money

		double PMT;
		//PARAMETER TESTING FOR BETWEEN 0-20%
		if (AR1 >= 0 & AR1 <= .2) {
			r = (AR1 / 12);
		}
		else {
			System.out.println("Annual Return must be within 0 and 20 percent" );
			System.out.print("Annual Return: ");
			AR1 = input.nextDouble();
			r = (AR1 / 12);
		}
		n = (YTW * 12);
		p = 0;
		f = PV;
		t = false;

		PMT = FinanceLib.pmt(r, n, p, f, t);

		System.out.printf("Amount to save monthly = $%,.2f%n", PMT);

		input.close();

	}

}
