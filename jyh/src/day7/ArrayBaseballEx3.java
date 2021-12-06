package day7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayBaseballEx3 {

	public static void main(String[] args) {
		/* 숫자 야구게임
		 * 컴퓨터가 랜덤으로 1~9사이의 중복되지 않은 세 수를 선택
		 * 사용자는 컴퓨터가 선택한 세 수를 맞추는 게임
		 * => 사용자가 처음으로 입력한 중복되지 않는 1~9사이의 세 수를 컴퓨터 수라 가정
		 * S : 숫자가 있고 위치가 맞는경우
		 * B : 숫자는 있지만 위치가 안맞는경우
		 * 3O: 맞는숫자가 하나도 없는경우
		 * 3S: 게임종료*/
		int arr[] = new int[3];
		int max = 9;
		int min = 1;
		int count = 0;
		Random r = new Random(); 
		
		int num2[] = new int[3];
		int j;
		int strike;
		int ball;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("컴퓨터 숫자가 입력되었습니다");
	
		do {											//랜덤으로 컴퓨터 숫자를 생성
			int random = r.nextInt(max-min+1)+min;
			int n ;
			for(n = 0 ; n < count ; n++ ) {
			
			
				if(arr[n]== random) {					//break; 로 인해 반복문을 중단하고 빠져나온다. 
					break;
				}
			}
			if(n==count) {
				arr[n] = random;
				count++;
			}
		}while(count != 3);							//랜덤으로 숫자 생성 종료.

		System.out.println();
			do											//사용자 숫자 입력하는 코드 시작
			{
				System.out.print("사용자 숫자를 입력하세요 : ");
		
				for(j = 0 ; j < num2.length ; j++ ) {
					num2[j] = scan.nextInt();
				}
				System.out.println(Arrays.toString(num2)); // 사용자 숫자 입력 및 출력
			
				strike = 0;									// 스트라이크 초기화
				
				for(int m = 0; m<arr.length ; m++) {		// 같은 숫자일때 스트라이트값 증가 저장
					if(arr[m] == num2[m]) {
					strike++;
					}
				}		
				
				ball = 0;									// 볼값 초기화
			
				for(int a = 0; a<arr.length; a++) {
					for(int b = 0; b<num2.length ; b++) {	// 저장되어있는 배열의 위치가 같을때 
						if(a == b) {						// continue로 인해 b++ 로 이동
							continue;						// 그리고 다시 for문 반복실행
						}
						if(arr[a] == num2[b]) {				// 위치가 다른 두 배열값이 같을때 볼값 증가
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
