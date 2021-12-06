package day5;

import java.util.Scanner;

public class DowhileBreakEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		for( ; num != 0 ; ) {
			System.out.print("점수를 입력하세요 : ");
			num = scan.nextInt();
		}
		System.out.println("-----do while 문-----");
		do {
			System.out.print("점수를 입력하세요 : ");
			num = scan.nextInt();
		}while(num != 0);
		
		
		scan.close();
	}

}
