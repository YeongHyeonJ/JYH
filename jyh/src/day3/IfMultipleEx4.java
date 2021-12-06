package day3;

import java.util.Scanner;

public class IfMultipleEx4 { //배수예제

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("정수를 입력하세요 : " );
		int num1 = scan.nextInt();
		
		
		if(num1 %2 == 0 && num1 % 3 !=0) {
			System.out.println(num1 + " = 2의 배수");
		}
		
		else if(num1 %3 == 0 && num1 % 2 !=0) {
			
			System.out.println(num1 + " = 3의 배수.");	
		}
		
		else if(num1 % 6 ==0) {
			
			System.out.println(num1 + " = 6의 배수.");
		}
		else
			System.out.println("'" + num1 + "'" + " 는 2,3,6의 배수가 아닙니다.");
		
		
	
		scan.close();

	}

}
