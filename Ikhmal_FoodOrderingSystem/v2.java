import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class v2 {


	static boolean dine=false,show=true;
	static char takeAwayUpper,checkout;
	static double price,totalItem,totalprice,serviceCharge,sst,finalPrice,pay,balance;
	static int i,quantity,indexMenuNum;
	static DecimalFormat df = new DecimalFormat("0.00");
	static ArrayList<Integer> menuNum = new ArrayList<Integer>();
	static ArrayList<Integer> mQuantity = new ArrayList<Integer>();
	static ArrayList<Double> itemPrice = new ArrayList<Double>();
  

   	static Scanner input = new Scanner(System.in);

   	static String[] menuName= {"Nasi Goreng Pataya","Bihun Goreng","Nasi Bujang","Milo Ice","Teh O Ice",};
   	static double[] menuPrice= {6,5,4,3.50,2.50};

   	//static ArrayList<String> orderName = new ArrayList<String>();
 
   

     
   	public static void main(String[] args) {

     
     	System.out.println("Dine In Or Take Away?");
     	System.out.println("If Dine In press (y) Or Take Away (n)");     
     	takeAwayUpper = Character.toUpperCase(input.next().charAt(0));
      
      	checking();
      	//order();
      	input.close();

  	}

  	//prompt & gets user to dine-in or get take-away and remembers state
  	//by storing it in variable "dine"
  	//If the entered characters aren't 'Y' or 'N', then
  	//the function will call itself again
  	//Else, it will execute menu()
  	static void checking(){

    	if (takeAwayUpper == 'Y') {
    		System.out.println("Dine-In selected");
      		dine = true;
      		myMenu();

    	} else if (takeAwayUpper == 'N') {
    		System.out.println("Take-Away selected");
      		dine = false;
      		myMenu();

    	} else {

      		System.out.println("Please enter (Y) for Dine In Or  (N) for Take Away");
      		takeAwayUpper = Character.toUpperCase(input.next().charAt(0));

      		if (takeAwayUpper != 'Y' || takeAwayUpper != 'N') {

        		checking();

      		} else {

        		myMenu();

      		}
    	}
  	}

  	//prints out menuName & menuPrice array
  	//prints out list of food ordered & price of ordered item
  	//then executes calculate() if menuNum's size is not empty
  	//executes orders()
   	static void myMenu() {

     	//start menu//
      	System.out.println("Menu");
      	for(int i=0; i < menuName.length; i++ ){
     
        	System.out.println(i+1 +"  ||"+ menuName[i]+"   RM"+ menuPrice[i]);

      	}
        System.out.println("6  ||Payment. ");
        System.out.println("7  ||Cancel Order. ");
   
        System.out.println("|=====================================|");
   
     	// end menu//

     	if(menuNum.size()!=0){
          
        	for(int i=0; i < menuNum.size(); i++ ){

          		totalItem= menuPrice[menuNum.get(i)] * mQuantity.get(i);
          		System.out.println("No."+ (i+1)+" "+menuName[menuNum.get(i)]+" x" +mQuantity.get(i)+"  RM"+totalItem );
     
      
        	}

	        calculate();
	        System.out.println("|=====================================|");
	        System.out.println("SST: RM"+ df.format(sst));
	        System.out.println("Service Charge: RM"+ df.format(serviceCharge));
	        System.out.println("Total Price: RM"+df.format(finalPrice));   

      	}
      	
      	order();

   	}

   	//prompts user to select menu item. If an invalid input is entered, 
   	//then call the function again
   	public static void order(){
    	//select order
    	System.out.println("Select your order");
    	int mnumber = input.nextInt();
    	System.out.println("|=====================================|");
    	mnumber = mnumber-1;


       	//do checking, valid input
       	if (mnumber >= 0 && mnumber <= 4){   
	        menuNum.add(mnumber);
	        System.out.println(menuName[mnumber]+ " selected");
	        System.out.print("Key in quantity: ");
	        int orderQuantity = input.nextInt();
	        mQuantity.add(orderQuantity);
	        System.out.println("|=====================================|");
	        myMenu();
	         
       	
       	} else {
          	//select payment
            if(mnumber==5){
                //loops menu again if order is empty
                if(menuNum.size()==0){

                    System.out.println("No food or beverage has been selected");
                    System.out.println("Please select ");
                    myMenu();

                //executes payment if there are ordered items
                }else{
           
                    payment();
                }
        	//exit system
           	}else if (mnumber==6){

            	//user cancel order
               	System.out.println("ORDER HAS BEEN CANCELED");

           	}else{
             	// if user keyin wrong number display error
               	System.out.println("Invalid Choice");
              	//re run function order
            
               	order();
         	}
       	}
	}

	//calculates the total price for all food ordered and checks
	//dine stat to calculate final price that include tax charges
	public static void calculate() { 
	    totalprice=0;

      	for(int i=0; i < menuNum.size(); i++ ){

	        totalItem= menuPrice[menuNum.get(i)] * mQuantity.get(i);
	        totalprice=totalprice + totalItem;
	        itemPrice.add(totalprice);
    
      	}
      
      	if(dine==true){

           	sst=totalprice * 0.06;
           	serviceCharge= totalprice * 0.10;

      	}else{

           	sst=totalprice * 0.06;
           	serviceCharge= totalprice * 0.00;

      	}

	    finalPrice=totalprice + sst + serviceCharge ;

	}

  	public static void payment(){
  		System.out.println("Your order costs: RM"+ df.format(finalPrice));
  		System.out.println("Remaining amount: RM"+ df.format(balance));
    	System.out.print(">>>Please insert payment RM: ");
    	pay += input.nextDouble();

    	balance = finalPrice - pay;
    
    	if(pay >= finalPrice){

      		System.out.println("|=====================================|");
      		System.out.println("|==============RECEIPT================|");
      		System.out.println("|=====================================|");

      		for(int i=0; i < menuNum.size(); i++ ){

        		totalItem= menuPrice[menuNum.get(i)] * mQuantity.get(i);
        		System.out.println("No."+ (i+1)+" "+menuName[menuNum.get(i)]+" x" +mQuantity.get(i)+"  RM"+df.format(totalItem));
        		System.out.println("|=====================================|");
    
      		}

      		System.out.println("SST: RM"+ df.format(sst));
      		System.out.println("Service Charge: RM"+ df.format(serviceCharge));
      		System.out.println("Total Price: RM"+df.format(finalPrice));
      		System.out.println("Balance: RM"+df.format(balance*-1));
      		System.out.println("Thank You For Your Purchase");

    	}else{
      		payment();
    	}
  	}
}


