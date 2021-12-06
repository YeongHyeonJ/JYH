package day5;

public class StarEx2 {

	public static void main(String[] args) {
		int i;
		int j;
		for(i=1 ; i <= 5 ; i++) {
			for(j =1 ; j <=5 ; j++) {
				if(j <= i) {
					System.out.print("*");
				}
			}System.out.println();
		}
		System.out.println("----------while----------");
		i = 1;
		while(i<=5) {
			j=1;
			while(j<=5) {
				if(j <= i) {
					System.out.print("*");
				}
				j++;				
			}System.out.println();
			i++;
		}
		
		
	}
}
