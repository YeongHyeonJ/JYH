package day13;

import java.util.Scanner;

public class ExgStringEx2 {

	public static void main(String[] args) {
		/* char charAt(int index) : 문자열에서 index번째에 있는 자료를 알려주는것
		 * */
		String str = "Hello";
		System.out.println(str + "에서 1번째 문자 : " + str.charAt(0));
		Scanner scan = new Scanner(System.in);
		
		char ch1 = scan.next().charAt(0);
		char ch2 = scan.next().charAt(1);
		System.out.println(ch1);
		System.out.println(ch2);
	}

}
