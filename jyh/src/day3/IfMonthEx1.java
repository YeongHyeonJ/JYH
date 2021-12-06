package day3;

import java.util.Scanner;

public class IfMonthEx1 { //월

		// 31 : 1 3 5 7 8 10 12
		// 30 : 4 6 9 11
		// 28 : 2
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월을 입력하세요 : ");
		int mon = scan.nextInt();
		
		if(mon == 2) {
			System.out.println(mon + "월의 마지막 일은 28일 입니다.");
		}
		else if(mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			System.out.println(mon + "월의 마지막 일은 30일 입니다.");
		}
		else if(mon == 1 || mon == 3  || mon == 5 || mon == 7 || 
				mon == 8 || mon == 10 || mon == 12) {
			System.out.println(mon + "월의 마지막 일은 31일 입니다.");
		}
		else {
			System.out.println("잘못 입력되었습니다.");
		}
		
		
		scan.close();
	}

}
