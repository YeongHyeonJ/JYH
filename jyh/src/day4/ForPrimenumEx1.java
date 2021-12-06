package day4;

import java.util.Scanner;

public class ForPrimenumEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("소수를 입력하세요 : ");
		int num = scan.nextInt();
		int i;
		int count = 0;
		for (i = 1 ; i <= num ; i ++) {
			if(num % i == 0 ) 
			count ++;
		}				
		if(count == 2)
			System.out.println(num + " 는 소수입니다.");
		else
			System.out.println(num + " 는 소수가 아닙니다.");
		
		scan.close();
	}
}
