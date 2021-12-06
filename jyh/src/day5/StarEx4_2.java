package day5;

public class StarEx4_2 {

	public static void main(String[] args) {
		int i = 1;
		int j;
		int m;
		while(i <= 5) {
			j =4;
			while( j >= 1){
				if(j >= i){
					System.out.print(" ");
				}
				j--;
			}
			m = 1;
			while( m <= 5){
				if(m <= i){
					System.out.print("*");
				}
				m++;
			}
			m = 1;
			while( m <= 5 ) {
				if(m <= i-1){
					System.out.print("*");
				}
				m++;
			}
			
			System.out.println();
			i++;
		}

	}
}
