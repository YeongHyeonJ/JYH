package day2;

public class AssignmentEx1 {

	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		num1 = num2; //num2 값을 num1에 저장
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		num1 = 10;
		num2 = 20;
		
		num2 = num1; //num1 값을 num2에 저장
		System.out.println("num1 = " + num1 + ", num2 = " + num2);

		num1 = num1 + num2; 
		System.out.println("num1 = " + num1 + ", num2 = " + num2);

	
	}
}
