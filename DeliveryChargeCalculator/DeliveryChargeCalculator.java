import java.util.Scanner;

class DeliveryChargeCalculator{
	public static void main(String[] args){
		
		Scanner inp = new Scanner(System.in);
		
		//prompt parcel weight
		System.out.println("Enter parcel weight in KG: ");
		//get parcel weight
		double weight = inp.nextFloat();
		
		//variable for storing final price
		double finalPrice = 0;
		
		if (weight < 2.5){
			finalPrice = weight * 3.5;
		}
		else if (weight <= 5.0 && weight >= 2.5){
			finalPrice = weight * 2.85;
		} 
		else if (weight > 5.0){
			finalPrice = weight * 2.45;
		}
		
		System.out.println(finalPrice);
		
	}
}