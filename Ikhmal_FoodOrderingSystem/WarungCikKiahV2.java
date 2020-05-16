import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class WarungCikKiahV2 {


	static boolean dine=false,show=true;
	static char takeAwayUpper,checkout;
	static double price,totalItem,totalprice,serviceCharge,sst,finalPrice,pay,balance, inPay;
	static int i,quantity,indexMenuNum;
	static DecimalFormat df = new DecimalFormat("0.00");
	static ArrayList<Integer> menuNum = new ArrayList<Integer>();
	static ArrayList<Integer> mQuantity = new ArrayList<Integer>();
	static ArrayList<Double> itemPrice = new ArrayList<Double>();
  

   	static Scanner input = new Scanner(System.in);

   	static String[] menuName= {"Nasi Goreng Pataya  ","Bihun Goreng        ","Nasi Bujang         ","Milo Ice            ","Teh O Ice           ",};
   	static double[] menuPrice= {6,5,4,3.50,2.50};

   	//static ArrayList<String> orderName = new ArrayList<String>();
 
   

     
   	public static void main(String[] args) {

     
     	//System.out.print(">>>Dine-In (Y) Or Take-Away (N)?: ");     
     	//takeAwayUpper = Character.toUpperCase(input.next().charAt(0));
      
      	checking();
        System.out.println("");
      	myMenu();
      	//order();
      	input.close();

  	}

  	//prompt & gets user to dine-in or get take-away and remembers state
  	//by storing it in variable "dine"
  	//If the entered characters aren't 'Y' or 'N', then
  	//the function will call itself again
  	//Else, it will execute menu()
  	static void checking(){
  		System.out.print(">>>Dine-In (Y) Or Take-Away (N)?: ");     
     	takeAwayUpper = Character.toUpperCase(input.next().charAt(0));
    	if (takeAwayUpper == 'Y') {
    		System.out.println("DINE-IN selected");
      		dine = true;
      		//myMenu();

    	} else if (takeAwayUpper == 'N') {
    		System.out.println("TAKE-AWAY selected");
      		dine = false;
      		//myMenu();

    	} else {

      		System.out.println("Please enter (Y) for Dine-In Or  (N) for Take-Away");
      		//ntakeAwayUpper = Character.toUpperCase(input.next().charAt(0));

      		//if (takeAwayUpper != 'Y' || takeAwayUpper != 'N') {

        		checking();

      		//} else {

        		//myMenu();

      		//}
    	}
    	
  	}

  	//prints out menuName & menuPrice array
  	//prints out list of food ordered & price of ordered item
  	//then executes calculate() if menuNum's size is not empty
  	//executes orders()
   	static void myMenu() {

     	//start menu//
     	System.out.println("---------------------------------------");
      	System.out.println("|     Welocome to Warung Cik Kiah     |");
      	System.out.println("---------------------------------------");
      	System.out.println(" No.|      FOOD NAME     | PRICE");
      	for(int i=0; i < menuName.length; i++ ){
     
        	System.out.println(" "+(i+1) +". |"+ menuName[i]+"|RM"+ df.format(menuPrice[i]));

      	}
      	System.out.println("---------------------------------------");
        System.out.println(" 6. |PAYMENT ");
        System.out.println(" 7. |CANCEL ORDER ");
   
        System.out.println("|=====================================|");
   
     	// end menu//

     	if(menuNum.size()!=0){
          	System.out.println("|--------------YOUR ORDER-------------|");
        	for(int i=0; i < menuNum.size(); i++ ){

          		totalItem= menuPrice[menuNum.get(i)] * mQuantity.get(i);
          		System.out.println(" "+(i+1)+". "+menuName[menuNum.get(i)]+" x" +mQuantity.get(i)+"  RM"+totalItem );
     
      
        	}

	        calculate();
	        System.out.println("|=====================================|");
	        System.out.println(" SST:                        RM"+ df.format(sst));
	        System.out.println(" Service Charge:             RM"+ df.format(serviceCharge));
	        System.out.println(" Total Price:                RM"+ df.format(finalPrice));   

      	}
      	
      	order();

   	}

   	//prompts user to select menu item. If an invalid input is entered, 
   	//then call the function again
   	public static void order(){
    	//select order
    	System.out.println("");
    	System.out.println("Select your order or enter '6' for PAYMENT or '7' to CANCEL and exit");
    	System.out.print(">>>Selection: ");
    	int mnumber = input.nextInt();
    	System.out.println("|=====================================|");
    	mnumber = mnumber-1;


       	//do checking, valid input
       	if (mnumber >= 0 && mnumber <= 4){   
	        menuNum.add(mnumber);
	        System.out.println(menuName[mnumber]+ " selected");
	        System.out.print(">>>Key in quantity: ");
	        int orderQuantity = input.nextInt();
	        mQuantity.add(orderQuantity);
	        System.out.println("");
	        myMenu();
	         
       	
       	} else {
          	//select payment
            if(mnumber==5){
                //loops menu again if order is empty
                if(menuNum.size()==0){

                    System.out.println("!!!!! No food or beverage has been selected !!!!");
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
  		System.out.println(" PAYMENT selected");

        do{
            System.out.println(" Your order costs: RM"+ df.format(finalPrice));
            System.out.println(" Remaining amount: RM"+ df.format(finalPrice - pay));
            System.out.print(">>>Please insert payment RM: ");
            inPay = input.nextDouble();
            if (inPay <= 0){
                System.out.println(" Please insert amount that is greater than 0!");
            }
            else{
                pay += inPay;
            }

            System.out.print("");

        }while (pay < finalPrice); 
        

    	balance = finalPrice - pay;
    

  		System.out.println("|=====================================|");
  		System.out.println("|==============RECEIPT================|");
  		System.out.println("|=====================================|");

  		for(int i=0; i < menuNum.size(); i++ ){

    		totalItem= menuPrice[menuNum.get(i)] * mQuantity.get(i);
    		System.out.println(" "+ (i+1)+". "+menuName[menuNum.get(i)]+" x" +mQuantity.get(i)+"  RM"+df.format(totalItem));
    		//System.out.println("|=====================================|");

  		}
        System.out.println("|-------------------------------------|");

  		System.out.println(" SST:                        RM"+ df.format(sst));
        System.out.println(" Service Charge:             RM"+ df.format(serviceCharge));
        System.out.println(" Total Price:                RM"+ df.format(finalPrice)); 
  		System.out.println("--------------------------------------");
        System.out.println(" Paid amount:                RM"+ df.format(pay));
        System.out.println(" Balance:                    RM"+ df.format(balance*-1));
        System.out.println("--------------------------------------");
  		System.out.println("*****Thank You For Your Purchase!*****");

    	
  	}
}


