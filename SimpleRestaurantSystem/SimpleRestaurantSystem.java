import java.util.Scanner;
import java.text.DecimalFormat; 

class SimpleRestaurantSystem{ 

    private static DecimalFormat df = new DecimalFormat("0.00");

    //DECISION
    public static boolean paid(double totalPrice, double inPrice){
    	if (inPrice >= totalPrice){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    public static void main(String args[]){ 

        String foodName[] = new String[4]; 
        foodName[0] = "Nasi Goreng Ayam"; 
        foodName[1] = "Chicken Chop"; 
        foodName[2] = "Fish & Chips"; 
        foodName[3] = "Fettuccine"; 

        double price[] = new double[4]; 
        price[0] = 5.0; 
        price[1] = 8.0; 
        price[2] = 6.5; 
        price[3] = 7.5; 


        //output
        String foodList = "";
        //output
        double totalPrice = 0;
        //output
        boolean payStat = false; 
        
        //input
        int quant = 0; 
        //input
        double paidPrice = 0;
        //input
        int sel = 0; 

        Scanner myIn = new Scanner(System.in); 

        System.out.println("**********************************************************");
        System.out.println("**************WELCOME TO WARUNG MAK LIMAH!****************");
        System.out.println("**********************************************************");

        while (sel != 6){ 

             
        	System.out.println("===========MAIN COURSES===============");
            for (int i = 1; i <= 4; i++){ 
                System.out.println(i+". "+foodName[i-1]+" | "+df.format(price[i-1])); 
            } 
            System.out.println("-------------YOUR ORDER-------------");
            System.out.println(foodList);
            System.out.println("++++++++TOTAL PRICE: "+ df.format(totalPrice)+"+++++++++++");
            System.out.println("5. Make payment");
            System.out.println("6. Cancel & Exit System");

            System.out.println("Please select food to order or proceed to payment: "); 

            sel = myIn.nextInt(); 

            //DECISION
            switch(sel){ 

                case 1: 
                    System.out.println(foodName[0]+" selected. Enter quantity:"); 
                    quant = myIn.nextInt();
                    foodList += foodName[0]+ ", " + quant + "\n";
                    totalPrice += price[0]*quant; 
                    break; 
                case 2: 
                    System.out.println(foodName[1]+" selected. Enter quantity:"); 
                    quant = myIn.nextInt();
                    foodList += foodName[1]+ ", " + quant + "\n";                   
                    totalPrice += price[1]*quant; 
                    break; 

                case 3:
                   	System.out.println(foodName[2]+" selected. Enter quantity:"); 
                    quant = myIn.nextInt();
                    foodList += foodName[2]+ ", " + quant + "\n";
                    totalPrice += price[2]*quant; 
                    break; 

                case 4: 
                    System.out.println(foodName[3]+" selected. Enter quantity:"); 
                    quant = myIn.nextInt();
                    foodList += foodName[3]+ ", " + quant + "\n"; 
                    totalPrice += price[3]*quant; 
                    break; 

                case 5:
                    //DECISION 
                    if(totalPrice > 0){
                    	while(payStat != true){
                    		System.out.println("Insert payment:");
                    		paidPrice += (myIn.nextDouble());
                    		payStat = paid(totalPrice,paidPrice);
                    		if (payStat == false){
                    			System.out.println("Current paid amount:"+ df.format(paidPrice));
                    			System.out.println("Remaining amount: "+ df.format(totalPrice-paidPrice)+"\nPlease insert more cash");	
                    		}
                    	}
                    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    	System.out.println("||Thank you for your purchase!||");
                    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    
                    	sel = 6;
                    
                    }
                    else{
                    	System.out.println("!!!!!!!!No food selected!!!!!!!!\nPlease select food item first.");
                    	break;
                    }

                case 6:
                	System.out.println("Exiting system...");

                default: 
                    System.out.println("Please enter the correct number");
                    break;  
            }
        } 
    }
     
}; 