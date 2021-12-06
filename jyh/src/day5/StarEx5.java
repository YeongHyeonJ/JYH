package day5;

public class StarEx5 {

	public static void main(String[] args) {
		int i;
		int j;
		int m;
		for(i=5 ; i >= 1 ; i--) {
			for(j =1 ; j <=5 ; j++) {
				if(j <= i) {
					System.out.print("*");
				}
			}System.out.println();
		}
		
		System.out.println();
		
		
		for(i=5 ; i >= 1 ; i--) {			
			for(j =4 ; j >=1 ; j--) {
				if(j >= i) {
					System.out.print(" ");
				}
			}
			
			for(m = 1; m <= 5 ; m++) {
				if(m <= i) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
		
		System.out.println();

		for(i=1 ; i <= 3 ; i++) {
			
			for(j =4 ; j >=1 ; j--) {
				if(j >= i) {
					System.out.print(" ");
				}
			}
			
			for(m = 1; m <= 5 ; m++) {
				if(m <= i*2-1) {
					System.out.print("*");
				}
			
			}
			
			System.out.println();
		}
		
		for(i=2 ; i >= 1 ; i--) {
			
			for(j =4 ; j >=1 ; j--) {
				if(j >= i) {
					System.out.print(" ");
				}
			}
			
			for(m = 1; m <= 5 ; m++) {
				if(m <= i*2-1) {
					System.out.print("*");
				}
			
			}
			
			System.out.println();
	
		}
	
	}
}
