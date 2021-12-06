package day5;

public class WhileHelloEx1 {

	public static void main(String[] args) {
		int i = 1;
		while(i<=5) {
			System.out.println("Hello World");
			i++;
		}
		System.out.println("------------------");
		i=5;
		while(i-- >= 1) {
		
			System.out.println("Hello World");
		}
	}
}
