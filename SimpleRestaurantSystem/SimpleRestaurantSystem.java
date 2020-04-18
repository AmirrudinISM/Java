import java.util.Scanner;
import java.text.DecimalFormat; 

//Owner: Amirrudin Ismail Bin Adlan Rahim
//ID: 5221322-0036
//Course: Principles of Computer Programming
//Institution: University of Kuala Lumpur

class SimpleRestaurantSystem{ 

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String args[]){ 

        //variables for every ordering operation
        String foodList = "";
        double totalPrice = 0;
        double remainingAmount = 0;
        boolean payStat = false; 
        char dineIn = ' ';
        boolean dineInStat = false;
        int quant = 0; 
        double paidPrice = 0;
        double taxVal = 0.0;
        double taxPrice = 0;
        //variable for action selection
        int sel = 0; 

        System.out.println("**********************************************************");
        System.out.println("**************WELCOME TO WARUNG MAK LIMAH!****************");
        System.out.println("**********************************************************");


        //prompt & get user wether to dine-in or take-away
        while (dineInStat != true){
            System.out.print(">>>Would you like to DINE-IN? [y/n]: ");
            dineIn = new Scanner(System.in).next().charAt(0);
            if (dineIn == 'y'){
                System.out.println("DINE-IN selected!");
                taxVal = 0.06;
                dineInStat = true;
            }
            else if (dineIn == 'n'){
                System.out.println("TAKE-AWAY selected!");
                dineInStat = true;
            }
            else{
                System.out.println("Please enter either 'y' for yes or 'n' for no");
            }
        }

        //loop for ordering food
        while (sel != 6) {

            //displays menu
            System.out.println("========================MAIN COURSES=======================");
            System.out.println("1.       Nasi Goreng Ayam         | RM5.00");
            System.out.println("2.       Chicken Chop             | RM8.00");
            System.out.println("3.       Fish & Chips             | RM6.50");
            System.out.println("4.       Fettuccine               | RM7.50");
            
            //displays order placed
            System.out.println("-------------------------YOUR ORDER------------------------");
            System.out.println(foodList);
            System.out.println("++++++++++++++++++++TOTAL PRICE: RM" + df.format(totalPrice) + "+++++++++++++++++++");
            System.out.println("5. Make payment");
            System.out.println("6. Cancel & Exit System");
            System.out.print(">>>Please select food to order or proceed to payment: ");

            sel = new Scanner(System.in).nextInt();

            switch (sel) {

                case 1:
                    System.out.print("Nasi Goreng Ayam selected. Enter quantity: ");
                    quant = new Scanner(System.in).nextInt();
                    foodList += "Nasi Goreng Ayam , x" + quant + "\n";
                    totalPrice += 5.0 * quant;
                    break;
                case 2:
                    System.out.print("Chicken Chop selected. Enter quantity: ");
                    quant = new Scanner(System.in).nextInt();
                    foodList += "Chicken Chop , x" + quant + "\n";
                    totalPrice += 8.0 * quant;
                    break;

                case 3:
                    System.out.print("Fish & Chips selected. Enter quantity: ");
                    quant = new Scanner(System.in).nextInt();
                    foodList += "Fish & Chips, x" + quant + "\n";
                    totalPrice += 6.5 * quant;
                    break;

                case 4:
                    System.out.print("Fettuccine selected. Enter quantity: ");
                    quant = new Scanner(System.in).nextInt();
                    foodList += "Fettuccine, x" + quant + "\n";
                    totalPrice += 7.5 * quant;
                    break;

                case 5:
                    //checks whether the user has ordered anything or not by checking the price.
                    //if the total price is 0, the that implies that the user has not ordered anything
                    if (totalPrice > 0) {
                        //6% GST is added if the user dines in.
                        if (dineIn == 'y'){
                            taxPrice = totalPrice * taxVal;
                            totalPrice += taxPrice;
                        }

                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Tax Price: RM"+df.format(taxPrice)+", Total price (after tax): RM" + df.format(totalPrice));
                        System.out.println("-----------------------------------------------------------");
                        
                        //prompts & get user for payment until the order is totally paid off
                        while (payStat != true) {
                            System.out.print(">>>Insert payment:");
                            paidPrice += new Scanner(System.in).nextDouble();
                            remainingAmount = totalPrice-paidPrice;
                         
                            if (remainingAmount <= 0){
    							payStat = true;
    						}
    						else{
    							payStat = false;
    						}
                    		
                    		if (payStat == false){
                                //displays current paid amount and remaining amount to let users know how much more is to be paid
                                System.out.println("-----------------------------------------------------------");
                    			System.out.println("Current paid amount: RM"+ df.format(paidPrice));
                    			System.out.println("Remaining amount   : RM"+ df.format(remainingAmount)+"\nPlease insert more cash");
                                System.out.println("-----------------------------------------------------------");	
                    		}
                        }
                        System.out.println("Remaining amount   : RM"+ df.format(remainingAmount));
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
                    break;

                default: 
                    System.out.println("Please enter the correct number");
                    break;  
            }
        } 
    }
     
}; 