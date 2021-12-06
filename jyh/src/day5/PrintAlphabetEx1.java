package day5;

public class PrintAlphabetEx1 {

	public static void main(String[] args) {
		char ch;
		char a;
		for(ch = 'a' ; ch <= 'z' ; ch++ ) {
			for(a = 'a' ; a <= ch ; a++) {
				{
					System.out.print(a);
				}
			}System.out.println();		
		}
	}
}
