package day4;

public class ForGCDEx1 {

	public static void main(String[] args) {
		/* 두 정수의 공약수들을 출력하는 코드를 for 문을 이용하여 작성하세요.
		 * 12 , 8
		 * i는 1부터 num1 까지 1씩 증가
		 * i 가 num1 의 약수이고 i가 num2 의 약수이면 i를 출력
		 * */
		
		int i , gcd = 0;
		int num1 = 12 ;
		int num2 = 8 ;
		for ( i = 1 ; i <= num1 ; i ++ ) {
			if(num1 % i == 0 && num2 % i == 0){
				gcd = i;
			}
		}
			System.out.println(num1 + "과 "+ num2 + "의 최대공약수 : " + gcd);
			
	}
}
