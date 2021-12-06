package day6;

public class ArraySumEx1 {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int []arr = new int[5];			
		
		for(i = 0 ; i < 5 ; i ++) {
			arr[i] = 2*(i+1);
			j += arr[i];			
		}System.out.println(j);
			
	}
}
