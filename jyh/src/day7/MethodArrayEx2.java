package day7;

public class MethodArrayEx2 {

	public static void main(String[] args) {
		int [] arr = {1,3,2};
		
		printArray(arr);
		//initArray(arr);
		sortArray(arr);
		printArray(arr);
		
		
	}
	public static void printArray(int []arr) {
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		//arr[0] = 10;
	}
	public static void initArray(int [] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = 0;
		}
	}
	
	public static void sortArray(int [] arr) {
		
		for(int i = 0; i < arr.length-1 ; i++) {
			for(int j = 0; j < arr.length-i-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}		
			}
		}
	}
}
