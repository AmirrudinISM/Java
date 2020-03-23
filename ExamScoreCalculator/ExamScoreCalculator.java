import java.util.Scanner;

class ExamScoreCalculator{
	public static void main(String[] args){
		//scanner object
		Scanner inpObj = new Scanner(System.in);
		
		//prompt student ID
		System.out.println("Enter Student ID: ");
		
		//get student ID
		String studentID = inpObj.nextLine();
		
		//prompt exam score
		System.out.println("Enter exam score: ");
		
		int examScore = inpObj.nextInt();
		
		//variable for storing grade
		char grade = ' ';
		
		//selection control
		if (examScore < 60){
			grade = 'F';
		}
		else if (examScore <= 69 && examScore >= 60){
			grade = 'D';
		}
		else if (examScore <= 79 && examScore >= 70){
			grade = 'C';
		}
		else if (examScore <= 89 && examScore >= 80){
			grade = 'B';
		}
		else if (examScore >= 90){
			grade = 'A';
		}
		
		System.out.println(grade);
	}
}