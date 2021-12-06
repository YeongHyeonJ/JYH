package day5;

public class StarEx4 {

	public static void main(String[] args) {
		int i;
		int j;
		int m;
		for(i=1 ; i <= 5 ; i++) {
			
			for(j =4 ; j >=1 ; j--) {
				if(j >= i) {
					System.out.print(" ");
				}
			}
			
			for(m = 1; m <= 9 ; m++) {
				if(m <= i*2-1) {
					System.out.print("*");
				}
			
			}
			
			System.out.println();
		}

	}

}
