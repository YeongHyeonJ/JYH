package day7;

public class MethodStarEx1 {

	public static void main(String[] args) {
		
		star('*',5);

	}
	
	public static void star(char ch , int st1) {
		
		for(int i=1 ; i <= st1 ; i++ ) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
