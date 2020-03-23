import java.util.Scanner;


public class SelectionStructures{
	public static void main(String []args){
		
		
		char gender = ' ';
		Scanner inp = new Scanner(System.in);
		System.out.println("Hello. What is your gender? ");
		gender = inp.next().charAt(0);
			
		if (gender == 'M'){
			System.out.println("Hello, Sir.");
		}
		else if(gender == 'F'){
			System.out.println("Hello, Madam.");
		}
		else{
			System.out.println("Hello, Apache Attack Helicopter");
		}
	}
}