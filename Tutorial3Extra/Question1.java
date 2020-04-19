import java.util.Scanner;

class Question1{
	public static void main(String[] args) {
		int maleCount = 0, femaleCount = 0, totalUser = 0;
		char proceed = ' ', gender = ' ';

		do{
			System.out.print("Enter M for MALE or F for FEMALE: ");
			gender = new Scanner(System.in).next().charAt(0);

			totalUser++;

			if (gender == 'M'){
				maleCount++;
			}
			else if( gender == 'F'){
				femaleCount++;
			}

			System.out.print("Do you want to continue? (Y/N): ");
			proceed = new Scanner(System.in).next().charAt(0);

			System.out.print("\n");
			
		}while(proceed != 'N');

		System.out.println("Total user            = " + totalUser);
		System.out.println("Total male user       = " + maleCount);
		System.out.println("Total female user     = " + femaleCount);

	}
}