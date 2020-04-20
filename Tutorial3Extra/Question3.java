import java.util.Scanner;

class Question3{
	public static void main(String[] args) {
		int limit = 0;

		System.out.println("How many times?");
		limit = new Scanner(System.in).nextInt();
		System.out.println("");
		for (int i = 0; i < limit; i++){
			System.out.println((i+1) + ". ITD 10103 – Fundamentals of Programming");
		}

		System.out.println("");
		int count = 0;
		while (count < limit){
			System.out.println((count+1) + ". ITD 10103 – Fundamentals of Programming");
			count++;	
		}
	}
}