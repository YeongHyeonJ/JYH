package day5;

public class DoWhileEx1 {

	public static void main(String[] args) {
		int i = 1 ;
		do {
			System.out.println("Hello");
			i++;
		}while(i <= 5 );
		System.out.println("for 문");
		i = 10;
		for( ; i <=5 ; i++) {
			System.out.println(i);
		}
		System.out.println("while 문");
		
		i = 10;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
		System.out.println("do while 문");
		i = 10;
		do {
			System.out.println(i);
			i++;
		}while(i <=5 );
	}

}
