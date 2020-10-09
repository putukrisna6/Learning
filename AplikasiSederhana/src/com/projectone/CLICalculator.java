package com.projectone;

import java.util.Scanner;
import com.calculate.*;

public class CLICalculator {
	
	static Operations calc = new Operations();
	
	public static class Calculator {
		private double stored = 0;
		
		private void twoVars(double a, char opr, double b) {
			switch (opr) {
			case '+':
				stored = calc.add(a, b);
				System.out.println(stored);
				break;
			case '-':
				stored = calc.subtract(a, b);
				System.out.println(stored);
				break;
			case '*':
				stored = calc.multiply(a, b);
				System.out.println(stored);
				break;
			case '/':
				stored = calc.divide(a, b);
				System.out.println(stored);
				break;
			case '%':
				stored = calc.remainder(a, b);
				System.out.println(stored);
			default:
				System.out.println("INV");
				break;
			}
		}
		
		private void oneVar(char opr, double b) {
			switch (opr) {
			case '+':
				stored = calc.add(stored, b);
				System.out.println(stored);
				break;
			case '-':
				stored = calc.subtract(stored, b);
				System.out.println(stored);
				break;
			case '*':
				stored = calc.multiply(stored, b);
				System.out.println(stored);
				break;
			case '/':
				stored = calc.divide(stored, b);
				System.out.println(stored);
				break;
			case '%':
				stored = calc.remainder(stored, b);
				System.out.println(stored);
				break;
			default:
				System.out.println("INV");
				break;
			}
		}
		
		private void helper() {
			System.out.println("How to use:");
			System.out.println("The calculator supports these form of input:");
			System.out.println("\t1. Two variables and an operand, like");
			System.out.println("\t\t1 + 1\n\t\t3 * 4");
			System.out.println("\tNote that it'll always reset the stored calculations");
			System.out.println("\t2. An operand and a variable, like");
			System.out.println("\t\t- 7\n\t\t* 7");
			System.out.println("\t3. Using Rule 1 and 2 in conjunction, can lead to");
			System.out.println("\t\t3 + 3 + 3");
			System.out.println("\tNote that PEMDAS does not apply here");
			System.out.println("\t4. While running, type 'C' to reset the stored amount");
			System.out.println("\t5. To exit calculation, type 'E'");
			System.out.println("Start calculating? Y/N");
		}
		
		private void run() {
			boolean exitState = false;
			Scanner scan = new Scanner(System.in);
			
			while (!exitState) {
				if (scan.hasNextInt()) {
					int a = scan.nextInt();
					char opr = scan.next().charAt(0);
					int b = scan.nextInt();
					twoVars(a, opr, b);
				}
				else if (scan.hasNext()) {
					char opr = scan.next().charAt(0);
					if (opr == 'C') {
						stored = 0;
						System.out.println(stored);
					}
					else if (opr == 'E') {
						exitState = true;
						System.out.println("Ending calculation...");
						start();
					}
					else if (scan.hasNextDouble()){
						double b = scan.nextDouble();
						oneVar(opr, b);
					}
					else oneVar('e', 0.0);
				}
			}
			
			scan.close();
		}
		
		private void startDecision(int a) {
			switch (a) {
			case 1:
				System.out.println("Running...");
				run();
				break;
			case 2:
				helper();
				Scanner input = new Scanner(System.in);
				char desc = input.next().charAt(0);
				if (desc == 'Y') startDecision(1);
				else startDecision(3);
				break;
			case 3:
				System.out.println("Terminating...");
				break;
			default:
				System.out.println("It looks like you've entered an invalid command!\nTaking you back to the start screen");
				start();
				break;
			}
		}
		
		public void start() {
			System.out.println("---------------------------------------------------------");
			System.out.println("CLI Based Calculator started!");
			System.out.println("This calculator can support the following operations:");
			System.out.println("\t• Addition (+)\n\t• Subtraction (-)\n\t• Multiplication (*)\n\t• Division (/)\n\t• Modulo (%)");
			System.out.println("Then, type the option numbers below to choose the option.");
			System.out.println("\t1 Run\n\t2 Help\n\t3 Exit");
			System.out.println("---------------------------------------------------------");
			
			Scanner picks = new Scanner(System.in);
			if (picks.hasNextInt()) {
				int decision = picks.nextInt();
				startDecision(decision);
			}
			else startDecision(-1);
			picks.close();
		}
	}

	public static void main(String[] args) {
		Calculator runIt = new Calculator();
		runIt.start();
	}
}
