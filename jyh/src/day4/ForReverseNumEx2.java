package day4;

public class ForReverseNumEx2 {

	public static void main(String[] args) {
		int num = 1230;
		int count = 0 ;
		for(; num != 0 ; ) {
			
			System.out.print(num % 10);
			num = num / 10; 
			
		}
	}
}

