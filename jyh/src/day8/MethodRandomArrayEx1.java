package day8;

import java.util.Arrays;
import java.util.Random;

public class MethodRandomArrayEx1 {

	public static void main(String[] args) {

		int arr[] = ArrRandom(1,45,6);
		System.out.println(Arrays.toString(arr)); 
		
	}
	
	public static int [] ArrRandom(int Min , int Max , int size) {
		int [] arr = new int [size];
		Random r = new Random();
		
		for(int i=0 ; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*(Max-Min+1)+Min);
					
		}return arr;
		
	}

}
