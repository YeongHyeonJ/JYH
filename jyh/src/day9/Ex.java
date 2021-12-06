package day9;

import java.util.Arrays;

public class Ex {

	public static void main(String[] args) {
		int min = 1;
		int max = 10;
		int size = 1;
		int [] lotto = randomArray(min,max,size);
		System.out.print(Arrays.toString(lotto));
		System.out.println();
	}



	public static int [] randomArray(int min, int max, int size) {
		int []arr = new int [size];
		for(int count = 0; count<size; ) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//random과 배열을 비교하여 중복된 숫자가 없으면
			if(!containsArray(arr, random, count)) {
				arr[count++] = random;
			}
		}
		return arr;
	}
	
	//arr배열에 있는 숫자를 num 숫자와 n번째 열까지 비교
	public static boolean containsArray(int []arr, int num, int n) {
		//배열의 길이보다 검사하는 갯수가 많으면 검사 갯수를 배열의 길이로,
		//아니면 원래 검사 개수로 변경
		n = arr.length < n ? arr.length : n;
		for(int i = 0; i<n; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
}