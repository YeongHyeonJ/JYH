package day6;

public class ArrayCopyEx1 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = num1;
		System.out.println(num2);
		num1 = 20;
		System.out.println(num1 + " , " + num2);

		
		int arr1[] = {1,2,3};
		int arr2[] = arr1;
		arr1[0] = 10;
		System.out.print("arr1 : ");
		for (int tmp : arr1) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		System.out.print("arr2 : ");
		for (int tmp : arr2) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
}
