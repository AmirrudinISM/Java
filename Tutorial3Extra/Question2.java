import java.util.Scanner;

class Question2{
	public static void main(String[] args) {
		double totalScore = 0, currentScore = 0, averageScore = 0; 
		int scoreCount = 0;
		String nums = "";

		while (currentScore != 999){
			System.out.print("Enter score: ");
			currentScore = new Scanner(System.in).nextDouble();
			if (currentScore != 999){
				scoreCount++;
				totalScore += currentScore;

				nums += currentScore+" + ";
			}
		}

		averageScore = totalScore/scoreCount;
		System.out.println(nums);
		System.out.println("Average Score = " + averageScore);
		

	}
}