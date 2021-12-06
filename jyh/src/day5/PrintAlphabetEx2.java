package day5;

public class PrintAlphabetEx2 {

	public static void main(String[] args) {
		char a;
		for(a = 'z' ; a >= 'a' ; a-- ) {
			System.out.print(a+ " ");
		}
		System.out.println();
		System.out.println("-----------------------while-----------------------");
		
		a = 'z';
		while(a >= 'a') {
			System.out.print(a + " ");
			a--;
		}

	}

}
