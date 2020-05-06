import java.util.Scanner;

class Tutorial4{
	public static void main(String[] args) {
			System.out.println(subject(3));	
			System.out.println(average(21,14,33));
			System.out.println(calculate(21,14,'/'));
	}

	//Q1
	static String subject(int selection){
		switch(selection){
			case 1:
				return "English";
				
			case 2:
				return "Mandarin";
				
			case 3:
				return "Arabic";
				
			default:
				return "Error";		
		}
	}

	//Q2
	static double average(int num1, int num2, int num3){
		double ave = (num1+num2+num3)/3;
		return ave;
	}

	//Q3
	static double calculate(int num1, int num2, char op){
		double res = 0;

		switch (op){
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num1 - num2;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = (double)num1 / num2;
				break;
			default:
				res = 0;
				break;
		}

		return res;
	}
};	