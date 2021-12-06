package day5;

public class MutipleTableEx1 {

	public static void main(String[] args) {
		int i, j;
		for(i = 2 ; i <= 9 ; i ++) {
			for(j = 1 ; j <= 9 ; j ++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}System.out.println();
			
		}
		i = 2;
		
		while(i<=9) {
			j = 1;
			while(j<=9) {
				System.out.println(i + " X " + j + " = " + (i*j));
				j++;
			}System.out.println();
			i++;			
		}
	}
}
