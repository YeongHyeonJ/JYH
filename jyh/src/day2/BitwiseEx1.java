package day2;

public class BitwiseEx1 {

	public static void main(String[] args) {
		int num1 = 3, num2 = 10;
		int and = num1 & num2;
		int or = num1 | num2;
		int not = ~num1;
		int xor = num1 ^ num2;
		
		System.out.println(num1 + " & " + num2 + " = " + and);
		System.out.println(num1 + " & " + num2 + " = " + or);
		System.out.println(num1 + " & " + num2 + " = " + xor);
		System.out.println(" ~ " + num1 + " = " + not);

	}

}
