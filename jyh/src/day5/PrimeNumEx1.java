package day5;

public class PrimeNumEx1 {

	public static void main(String[] args) {
		int i; 
		int j;
		int count = 0;
		
		for(i=2 ; i <= 100; i++) {
			count = 0;
			for (j = 1 ; j <= 100 ; j ++) {
				
				if(i % j == 0 ) 
				count ++;
			}if(count == 2) {
				System.out.println(i + " 는 소수입니다.");
			}
		}

	}

}
