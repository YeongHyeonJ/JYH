package day3;

import java.util.Scanner;

public class SwitchMonthEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("월을 입력하세요 : ");
		int mon = scan.nextInt();
		
		switch(mon) {
		case 1 , 3 , 5 , 7 , 8 , 10 , 12 :
			System.out.println(mon + "월의 마지막 일은 31일 입니다.");
			break;
		case 4 , 6 , 9 , 11 :
			System.out.println(mon + "월의 마지막 일은 30일 입니다.");
			break;
		case 2 :
			System.out.println(mon + "월의 마지막 일은 28일 입니다.");
			break;
		
			default :
			System.out.println("잘못된 입력입니다.");
		
		
		}
		
		
		
		
		
		scan.close();
	}

}
