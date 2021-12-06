package day7;

import java.util.Arrays;
import java.util.Random;

public class ArrayRandomEx1 {

	public static void main(String[] args) {
		int arr[] = new int[3];
		int max = 9;
		int min = 1;
		Random r = new Random(); 
		
		for(int i = 0 ; i < arr.length ; i++ ) {			
				int random = r.nextInt(max-min+1)+min;
				arr[i] = random;										
			}System.out.print(Arrays.toString(arr)); 

		
	}
}
