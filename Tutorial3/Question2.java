import java.util.Scanner;
class Question2{
	public static void main(String[] args) {
		int i = 1;

		//while
		while (i != 9){
			System.out.print("Enter any number or enter 9 to EXIT:");
			i = new Scanner(System.in).nextInt();
			System.out.println(i);
			
		}

		System.out.println("Thank u!");
		/*
		//for
		for(i = 1; i <= 30; i++){
			System.out.println(i);
		}

		i = 1;
		//do-while
		do{
			System.out.println(i);
			i++;
		}while(i <= 30);
		*/
	}
}