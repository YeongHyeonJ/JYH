package day1;

public class PrintEx1 {

	public static void main(String[] args) {
		System.out.println("Hello!!");
		System.out.println("Hello~~");
		System.out.println();
		System.out.print("Hello?");
		System.out.print("Hello?");
		System.out.println();
		int num1 = 10;
		System.out.println(num1);
		num1 = num1 + 20;
		System.out.println("age : " + num1);
		
		int num2 = 20;
		char operator = '+';
		
		System.out.println(num1 + operator + num2 + "=" + num1 + num2);
		System.out.println(""+num1 + operator + num2 + "=" + num1 + num2);
		System.out.println(""+num1 + operator + num2 + "=" + (num1 + num2));
	}

}
