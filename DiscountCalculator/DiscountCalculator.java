import java.util.Scanner;

class DiscountCalculator{
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);
		
		//prompt item price
		System.out.println("Enter item price: ");
		
		//get price
		double price = inp.nextDouble();
		
		//prompt discount code
		System.out.println("Enter discount code: );
		
		//get code
		char code = inp.next().charAt(0);
		
		double finalPrice = 0;
		double discountAmount = 0;
		double discountRate = 0;
		
		switch (code){
			case 'H':
				discountRate = 0.5;
				break;
			case 'F':
				discountRate = 0.4;
				break;
			case 'T':
				discountRate = 0.33;
				break;
			case 'Q':
				discountRate = 0.25;
				break;
			case 'Z':
				discountRate = 0.0;
				System.out.println("No discount");
			default:
				System.out.println("Invalid pricing code");
		}
		
		discountAmount = price * discountRate;
		finalPrice = price - discountAmount;
		
	}
}