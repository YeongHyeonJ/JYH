package day2;

import java.util.Scanner;

public class ScannerEx2_2 {

	public static void main(String[] args) {
		int num1, num2 ;
		System.out.print("두 정수를 입력하세요(예:1 2) : ");
		
		Scanner scan = new Scanner(System.in);
		
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		int res = num1 + num2 ;
		
		System.out.println(num1 + " + " + num2 + " = " + res);
		
		double res2 = (double)num1 / num2 ;

		System.out.println(num1 + " / " + num2 + " = " + res2);
		
		scan.close();
	}

}
