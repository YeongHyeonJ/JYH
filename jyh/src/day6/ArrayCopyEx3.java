package day6;

public class ArrayCopyEx3 {

	public static void main(String[] args) {
		int arr1[] = {1,2,3};
		int arr2[] = new int[arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
			
		}
		arr1[0] = 10;
		System.out.print("arr1 ; ");
		for(int tmp : arr1) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		System.out.print("arr2 ; ");
		for(int tmp : arr2) {
			System.out.print(tmp + " ");
		}
		System.out.println();


	}

}
