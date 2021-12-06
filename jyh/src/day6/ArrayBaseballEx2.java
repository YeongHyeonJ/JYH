package day6;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBaseballEx2 {

	public static void main(String[] args) {
		/* 숫자 야구게임
		 * 컴퓨터가 랜덤으로 1~9사이의 중복되지 않은 세 수를 선택
		 * 사용자는 컴퓨터가 선택한 세 수를 맞추는 게임
		 * => 사용자가 처음으로 입력한 중복되지 않는 1~9사이의 세 수를 컴퓨터 수라 가정
		 * S : 숫자가 있고 위치가 맞는경우
		 * B : 숫자는 있지만 위치가 안맞는경우
		 * 3O: 맞는숫자가 하나도 없는경우
		 * 3S: 게임종료*/
		
		int num[] = new int[3];
		int num2[] = new int[3];
		int i;
		int j;
		int strike;
		int ball;
		Scanner scan = new Scanner(System.in);
		System.out.print("컴퓨터 숫자를 입력하세요 : ");
				
		for(i = 0 ; i < num.length ; i++) {
			num[i] = scan.nextInt();
		}
		
		System.out.print(Arrays.toString(num));
		
		System.out.println();
			do	
			{
				System.out.print("사용자 숫자를 입력하세요 : ");
		
				for(j = 0 ; j < num2.length ; j++ ) {
					num2[j] = scan.nextInt();
				}
				System.out.println(Arrays.toString(num2));
			
				strike = 0;
				
				for(int m = 0; m<num.length ; m++) {
					if(num[m] == num2[m]) {
					strike++;
					}
				}		
				
				ball = 0;
			
				for(int a = 0; a<num.length; a++) {
					for(int b = 0; b<num2.length ; b++) {
						if(a == b) {
							continue;
						}
						if(num[a] == num2[b]) {
							ball++;						
						}
					
					}
				}
			
				if(strike != 0) {
					System.out.print(strike + "S");
				}
				if(ball != 0) {
					System.out.print(ball + "B");
				}
				if(strike == 0 && ball == 0) {
					System.out.print("3O");
				}
				System.out.println();
			
			}
			while(strike !=3);
			
			System.out.println("정답입니다. 프로그램을 종료합니다.");
		
		scan.close();
	}
}
