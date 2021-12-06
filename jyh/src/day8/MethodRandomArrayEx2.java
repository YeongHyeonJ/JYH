package day8;

import java.util.Arrays;
import java.util.Random;

public class MethodRandomArrayEx2 {

	public static void main(String[] args) {

		ArrRandom(1,6);
		
	}
	
	public static void ArrRandom(int Min , int Max) {
		int [] arr = new int [6];
		Random r = new Random();
		int count = 0;
		
		do {
			int random = r.nextInt(Max-Min+1)+Min;
			int i;
			for( i = 0 ; i < count ; i++ ) {
				
													//arr[i] == random 이면 
				if(arr[i]== random) {				//break로 인해 for문을 빠져나옴
					break;							//for문을 빠져나올 때 i++ 진행
					}
				}
				if(i==count) {
					arr[i] = random;
					count++;
				}
		
		}while(count != 6);
	System.out.println(Arrays.toString(arr));

	}

}
