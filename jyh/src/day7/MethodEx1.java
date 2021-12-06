package day7;

public class MethodEx1 {

	public static void main(String[] args) {
	
		int num = sum(1,2);
		System.out.println(num);
		System.out.println(sum(1,2));
		int a=1, b=2;
		System.out.println(sum(a,b));
		
		sum2(4,5);
		// 에러코드 : num = sum2(4,5);
		
	}
		/* 기능 : 두정수의 합을 알려주는 메소드
		 * 매개변수 2개
		 * 리턴타입 : 두 정수의 합 => 정수 > int
		 * 메소드명 : sum
		 * */
		
	public static int sum(int n1 , int n2) {
		int result = n1 + n2;
						
		return result;
	}
	/*
	 * 두 정수의 합을 콘솔에 출력
	 * 매개변수 2개 int n3 , int n4
	 * 리턴타입 int
	 * 메소드명 sum2
	 */
	public static void sum2(int n1, int n2) {
		int result = n1 + n2 ;
		System.out.println(result);
	}
}

