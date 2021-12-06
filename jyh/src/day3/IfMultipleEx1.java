package day3;

import java.util.Scanner;

public class IfMultipleEx1 { //배수예제

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("정수를 입력하세요 : " );
		int num1 = scan.nextInt();
		
		if(num1 %2 == 0) {
			System.out.println(num1 + " = 2의 배수입니다.");
		}
		else
			System.out.println(num1 + " = 2의 배수가 아닙니다.");
			
		scan.close();

	}

}
