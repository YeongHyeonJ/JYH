package day5;

public class WhileMutipleTableEx1 {

	public static void main(String[] args) {
		int i = 1 , num = 7;
		while(i <= 9) {
			System.out.println(num + " X " + i + " = " + (num*i));
			i++;
		}

		System.out.println();
		
		i = 0;
		num = 6;
		while(i++ <9) {
			System.out.println(num + " X " + i + " = " + (num*i));
		}
	}
}
