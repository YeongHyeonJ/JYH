package day4;

public class ForGCDBreakEx1 {

	public static void main(String[] args) {
		int i;
		int num1 = 12, num2 = 8;
		
		for(i = num1; i>=1; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.println(num1 + "과 " + num2 + "의 최대 공약수 : " + i);
				break;
			}
		}

	}

}
