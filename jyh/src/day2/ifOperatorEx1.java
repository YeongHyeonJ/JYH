package day2;

public class ifOperatorEx1 {

	public static void main(String[] args) {
		int score = 85;
		char isA = ((score <= 100) && (score >= 90)) ? 'Y' : 'N' ;
		
		System.out.println(score + "점은 A학점인가요? " + isA);

		
		int num1 = 11;
		String isOdd = num1 % 2 == 1 ? "Yes" : "No";
		
		System.out.println(num1 + "은 홀수인가요? " + isOdd);
		
	}

}
