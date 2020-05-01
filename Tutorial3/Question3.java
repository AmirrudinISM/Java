import java.util.Scanner;

class Question3{
	public static void main(String[] args) {
		int number = 0, product = 0;

		do{
			number = 0;
			System.out.print("Please enter number:");
			number = new Scanner(System.in).nextInt();

			product = number * 10;
			System.out.println( number + " * 10 = " + product);

		}while (product < 100);
	}
}