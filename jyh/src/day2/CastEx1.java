package day2;

public class CastEx1 {

	public static void main(String[] args) {
		
		// 정수를 실수에 저장하는경우 자동변환
		// 문자를 큰 정수나 실수에 저장하는 경우
		
		double num1 = 0;
		byte num2 = 76;
		int num3 = num2;
		
		char ch = '+';
		int num4 = ch;
		
		int num5 = (int)0.0;
		// float num6 = 1.23; // 1.23은 double형이기 때문에 뒤에 f붙이던가
		// 아니면 1.23 앞에 (float)을 붙여준다.
		
		System.out.println(num1);
		System.out.println(num3);
		System.out.println(num4); 
		System.out.println(num5);
		
	}
}
