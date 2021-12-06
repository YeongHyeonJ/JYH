package day2;

public class ComparisonEx1 {

	public static void main(String[] args) {
		
		int age = 16;
		boolean isAdult = age >= 19;
		System.out.println(age + "살은 성인인가? " + isAdult);
		
		int num1 = 32;
		
		boolean isEven = num1 % 2 == 0;
		boolean isOdd = num1 % 2 == 1;
		System.out.println(num1 + "은 짝수인가 ? "+ isEven);
		

	}
}
