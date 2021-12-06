package day8;

import java.util.Arrays;
import java.util.Random;

public class MethodArrayContainsEx2 {

	public static void main(String[] args) {
		int lotto [] = { 1, 2, 3, 4, 5, 6};
		int num = 1;
		int Min = 1 , Max = 45 , size = 6;
		int arr[] = RandomArray(Min,Max,size);
		System.out.println(Arrays.toString(arr)); 
		if(containsArray(lotto, num)) {
			System.out.println(num + "는 배열에 있다.");
		}
		else {
			System.out.println(num + "는 배열에 없다.");
		}
//		if(containsArray2(lotto, num, 2)) {
//			System.out.println(num + "는 배열에 있다.");
//		}
//		else {
//			System.out.println(num + "는 배열에 없다.");
//		}
		
		int [] lotto2 = RandomArray(1, 7, 6);
		System.out.println(Arrays.toString(lotto2));

	}
	
	public static boolean containsArray(int []arr, int num) {
		for(int tmp : arr) {
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}
	
//	public static boolean containsArray2(int []arr, int num, int n) {
//		
//		//n = arr.length < n ? arr.length : n;	
//		for(int i = 0 ; i < n; i++) {
//			if(arr[i] == num) {
//				return true;
//			}
//		return false;		
//	}
	
	public static int [] RandomArray(int Min , int Max , int size) {
		int count = 0;
		int [] arr = new int [size];
		Random r = new Random();
		do {
			int random = r.nextInt(Max-Min+1)+Min;
			int i = 0;
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
			}while(count != size);		
		return arr;
	}
}


