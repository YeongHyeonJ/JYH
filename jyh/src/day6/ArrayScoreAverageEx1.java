package day6;

import java.util.Scanner;

public class ArrayScoreAverageEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[5];
		int i;
		int Av = 0;

		for(i = 0; i < 5 ; i ++) {
			System.out.print("성적을 입력하세요 : ");
			arr[i] = scan.nextInt();
				for( ; arr[i] > 100 ; ) {
					System.out.println("잘못된 입력입니다.");
					System.out.print("성적을 입력하세요 : ");
					arr[i] = scan.nextInt();
				}
			Av += arr[i];
		}
		
		System.out.println("점수의 평균은 = " + ((double)Av/5));

		scan.close();
	}

}
