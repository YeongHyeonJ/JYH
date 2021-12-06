package day7;

import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 범위정수 만드는법
		 * Matr.random() : 0이상 1미만의 랜덤한 실수를 생성
		 * Random 클래스에서 제공하는 nextInt(정수) : 0이상 정수미만
		 * */
		int min = 5, max = 10 ;
		Random r = new Random();
		
		for(int i = 0 ; i < 5 ; i++) {
			int random = (int)(Math.random()*(max-min+1)+min);
			System.out.print(random + " ");
		}
		System.out.println();
		System.out.println("------------------------------");
		
		
		
		for(int i = 0 ; i < 5 ; i++) {
			int random = r.nextInt(max-min+1)+min;
			System.out.print(random + " ");
		}
		

	}
}
