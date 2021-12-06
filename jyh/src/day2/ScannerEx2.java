package day2;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println("입력된 정수는 " + num1 + " 입니다.");
		
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		System.out.println("입력된 정수는 " + num1 + " 입니다.");

		System.out.println("정수의 합은 " + (num1 + num2) + " 입니다.");
		System.out.println(num1 + " / " + num2 + " = " +((double)num1 / num2));
		
		
		
		
		
		
		
		scan.close();

	}

}
