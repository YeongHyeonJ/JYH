package day6;

public class ArrayForEx1 {

	public static void main(String[] args) {
		int arr[] = new int[5];
		int sum;
		int i;
		
		for(i = 0 ; i < 5 ; i++ ) {
			arr[i] = 2 * i + 2;
		}
		sum = 0;
		for(int tmp : arr) {
			sum += tmp;
			
			
		}System.out.println(sum);
	}

}
