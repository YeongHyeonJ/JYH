package day4;

public class BreakEx1 {

	public static void main(String[] args) {
		for( ; ; ) {
			System.out.println("Hello");
			break;
		}

		
		int i;
		for (i =1; i<=5 ; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(i = 1; ; i++) {
			System.out.print(i+ " ");
			if(i == 5) {
				break;
			}
		}
		System.out.println();
	}
}
