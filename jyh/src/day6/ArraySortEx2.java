package day6;

import java.util.Arrays;

public class ArraySortEx2 {

	public static void main(String[] args) {
		int num [] = {1, 10, 9, 3, 6, 2, 3, 4};
		// 
		
		Arrays.sort(num);
		
		for(int tmp : num) {
			System.out.print(tmp + " ");
		}
	}

}
