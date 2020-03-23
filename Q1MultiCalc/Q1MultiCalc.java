import java.util.Scanner;

public class Q1MultiCalc{
	public static void main(String [] args){
		int num1 = 0, num2 = 0;
		
		Scanner inp = new Scanner(System.in);
		
		System.out.println("Enter num1: ");
		num1 = inp.nextInt();
		
		System.out.println("Enter num2: ");
		num2 = inp.nextInt();
		
		int sum = num1 + num2;
		int diff = num1 - num2;
		int prod = num1 * num2;
		double quot = 0;
		if (num2 != 0){
			quot = (double)num1 / (double)num2;
		}
		else{
			quot = 0;
		}
		
		System.out.println("Sum = " + sum);
		System.out.println("Difference = " + diff);
		System.out.println("Product = " + prod);
		System.out.println("Quotient = " + quot);
	}
}