package day3;

import java.util.Scanner;

public class ifArithmeticEx1 {  //산술연산자 예제

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			
			System.out.print("두 정수와 기호를 입력하세요 : " );
			int num1 = scan.nextInt();
			char ch1 = scan.next().charAt(0);
			int num2 = scan.nextInt();
		
		if(ch1 == '+') {
			 System.out.println("두 정수의 합은 = " + (num1 + num2) + " 입니다.");
		}
		else if(ch1 == '-') {
			 System.out.println(num1 + " " + ch1 + " "  + num2 + " = " + (num1 - num2));
		}
		else if(ch1 == '*') {
			 System.out.println(num1 + " " + ch1 + " "  + num2 + " = " + (num1 * num2));
		}
		else if(ch1 == '/') {
			 System.out.println(num1 + " " + ch1 + " "  + num2 + " = " + ((double)num1 / num2));
		}
		else if(ch1 == '%') {
			 System.out.println(num1 + " " + ch1 + " "  + num2 + " = " + (num1 % num2));
		}
		else
			System.out.println(ch1 + " 는 산술 연산자가 아닙니다.");
		
		scan.close();
	}

}
