package day5;

public class PrintNumEx1 {

	public static void main(String[] args) {
		int i;
		int j;
		for(i = 1 ; i <= 9 ; i ++) {
			System.out.print(i + " ");
			if(i % 3 == 0)
			System.out.println();
		}
		
		for(i = 1 ; i <= 9 ; i ++) {
			for(j = 1 ; j<=9 ; j ++) {
				if(i == j) {
					System.out.print(i + " ");
				}
			}if(i%3 == 0) {
				System.out.println();
			}
		}
	}
}
