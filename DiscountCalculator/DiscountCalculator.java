import java.util.Scanner;

class DiscountCalculator{
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);
		
		//prompt item price
		System.out.print("Enter item price: ");
		
		//get price
		double price = inp.nextDouble();
		
		char code = ' ';
		
		//declare variables
		double finalPrice = 0;
		double discountAmount = 0;
		double discountRate = 0;
		
		
		while ( code != 'E'){
			//prompt discount code
			System.out.println("H: 50%\nF: 40%\nT: 33%\nQ: 25%\nZ: 0%\nE to EXIT");
			System.out.print("Enter discount code: ");
		
			//get code
			code = inp.next().charAt(0);
			
			switch (code){
				case 'H':
					System.out.println("Discount rate: 50%");
					discountRate = 0.5;
					break;
				case 'F':
					System.out.println("Discount rate: 40%");
					discountRate = 0.4;
					break;
				case 'T':
					System.out.println("Discount rate: 33%");
					discountRate = 0.33;
					break;
				case 'Q':
					System.out.println("Discount rate: 25%");
					discountRate = 0.25;
					break;
				case 'Z':
					System.out.println("Discount rate: 0%");
					discountRate = 0.0;
					break;
				default:
					System.out.println("Invalid pricing code");
					break;
			}	
		}
		
		
		discountAmount = price * discountRate;
		finalPrice = price - discountAmount;

		System.out.println("Discounted amount: RM" + discountAmount);
		System.out.println("Final price: RM" + finalPrice);


	}
}