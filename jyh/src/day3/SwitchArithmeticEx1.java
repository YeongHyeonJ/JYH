package day3;

import java.util.Scanner;

public class SwitchArithmeticEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수와 산술 연산자를 입력하세요 : ");
		int num1 = scan.nextInt();
		char ch1 = scan.next().charAt(0);
		int num2 = scan.nextInt();
		

		switch(ch1) {
		case '+' :
			System.out.println(num1 + " " + ch1 + " " + num2 + " = " + (num1 + num2));
			break;
		case '-' :
			System.out.println(num1 + " " + ch1 + " " + num2 + " = " + (num1 - num2));
			break;
		case '*' :
			System.out.println(num1 + " " + ch1 + " " + num2 + " = " + (num1 * num2));
			break;
		case '/' :
			System.out.println(num1 + " " + ch1 + " " + num2 + " = " + ((double)num1 / num2));
			break;
		case '%' :
			System.out.println(num1 + " " + ch1 + " " + num2 + " = " + (num1 % num2));
			break;
		default :
			System.out.println(ch1 + "잘못된 연산자 입니다.");
		
		}
		
		
		
		
		scan.close();
	}

}
