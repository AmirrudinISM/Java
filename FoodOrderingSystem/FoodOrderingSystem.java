import java.util.Scanner;
import java.text.DecimalFormat; 

class FoodOrderingSystem{
	
	//a library to format doubles to display only 2 decimal places
	//used for displaying price
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {
		//variables needed for system's operation
		String order = " ";
		double totalPrice = 0, selectedPrice = 0, remainingPrice = 0, paidPrice = 0;
		int quantity = 0;
		
		//selection
		int sel = 0;
		
		//menu
		System.out.println("================================");
		System.out.println("   Welcome to Warung Cik Kiah   ");
		System.out.println("================================");
		System.out.println("======== MENU =====|====PRICE===");
		System.out.println("1.   Chicken Chop  |   RM  8.90");
		System.out.println("2.   Steak         |   RM 12.90");
		System.out.println("3.   Fish & Chips  |   RM 10.50");
		System.out.println("4.   Juice         |   RM  4.00");
		System.out.println("--------------------------------");

		//prompt & get sel
		System.out.print(">>> Please select food or enter any number to cancel order: ");
		sel = new Scanner(System.in).nextInt();
		
		//select food or immediately exits system if user selects 
		//anything besides the displayed items
		switch (sel){
			case 1:
				order = "Chicken Chop";
				selectedPrice =  8.9;
				break;
			
			case 2:
				order = "Steak";
				selectedPrice =  12.9;
				break;

			case 3:
				order = "Fish & Chips";
				selectedPrice =  10.5;
				break;

			case 4:
				order = "Juice";
				selectedPrice =  4.0;
				break;

			default:
				System.out.println("No items selected. Exiting system...");
				break;
		}

		//if the user has selected any food item, proceed to cost calculation
		if (order != " "){
			System.out.println("Food selected: " + order);
			System.out.print(">>>Please enter quantity: ");
			quantity = new Scanner(System.in).nextInt();
			totalPrice = selectedPrice * quantity;
			
			//"receipt"
			System.out.println("Your order: " + order + ", Amount: "+quantity +", Total Price: RM" + df.format(totalPrice));
			
			//payment-prompt loop that ends when remaining price is reduced to zero
			remainingPrice = totalPrice;
			while ((remainingPrice) > 0){
				System.out.println("Remaining price: RM"+ df.format(remainingPrice));				
				System.out.print(">>> Please enter payment: ");
				paidPrice = new Scanner(System.in).nextDouble();
				remainingPrice -= paidPrice;
			}

			System.out.println("Thank you!");
		}
		
	}
};