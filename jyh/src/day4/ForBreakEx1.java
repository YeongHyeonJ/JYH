package day4;

import java.util.Scanner;

public class ForBreakEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		
		
		for(int i = 1 ; i != 0 ; ) {
			System.out.print("정수를 입력하세요 : " );		
			int num = scan.nextInt();
			i = num;
			if(i == 0) 
				
			break;
		}
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}

}
