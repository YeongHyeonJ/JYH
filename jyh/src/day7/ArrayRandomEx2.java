package day7;

import java.util.Arrays;
import java.util.Random;

public class ArrayRandomEx2 {

	public static void main(String[] args) {
		int arr[] = new int[3];
		int max = 9;
		int min = 1;
		int count = 0;
		Random r = new Random(); 
		
		
			
		do {
			int random = r.nextInt(max-min+1)+min;
			int i ;
			for(i = 0 ; i < count ; i++ ) {
			
			
				if(arr[i]== random) {
					break;
					}
				}
				if(i==count) {
					arr[i] = random;
					count++;
				}
			}while(count != 3);
			

		System.out.print(Arrays.toString(arr));

		
	}
}
