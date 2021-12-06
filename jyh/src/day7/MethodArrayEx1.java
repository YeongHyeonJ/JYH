package day7;

public class MethodArrayEx1 {

	public static void main(String[] args) {
		int [] arr = {1,2,3};
		printArray(arr);
		printArray(arr);
	}

	public static void printArray(int []arr) {
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		arr[0] = 10;
	}
}
