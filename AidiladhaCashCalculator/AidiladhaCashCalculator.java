import java.util.Scanner;

class AidiladhaCashCalculator{
	public static void main(String[] args) {
		int totalCash = 0;
		char levelCode = ' ';

		for (int i = 0; i < 2345; i++){
			System.out.print("Please enter level: ");
			levelCode = new Scanner(System.in).next().charAt(0);
			switch(levelCode){
				case 'F':
					totalCash += 50;
					break;
				case 'D':
					totalCash += 50;
					break;
				case 'B':
					totalCash += 70;
					break;
				case 'M':
					totalCash += 90;
					break;
				case 'P':
					totalCash += 90;
					break;
			}
		}
		System.out.println("Oh noi I made a mistake!");
		System.out.println("Total cash to give away: RM"+ totalCash+".00");
	}
}