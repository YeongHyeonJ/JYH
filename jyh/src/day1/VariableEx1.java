package day1;

public class VariableEx1 {

	public static void main(String[] args) {
		char score;
		score = 'f'; // char는 문자열이기에 '' 를 꼭 써준다.
		
		int age = 1;
		
		double avg = 0.0;
		float avg2 = 0.0f; //float은 소수점 뒤에 f 를 붙여야 한다.
		
		boolean isAdult = false; //true or false
		
		int num = 1000;
		byte num1 = 100; // byte는 1000 x
		
		int num2 = -2147483648;
		int num3 = 2147483647;
		
		System.out.println(isAdult);
		System.out.println(score);
		int 변수; // 한글이 가능은 하다. 숫자사용 x , 대소문자 구분가능 , 영어.숫자._.한글 사용가능 첫글자에 숫자 x
		
		int num4 = 0x11; //16진수 0x
		System.out.println("num4 = " + num4);
		int num5 = 011; //8진수   0
		System.out.println("num5 = " + num5);
		int num6 = 0b11; //2진수  0b
		System.out.println("num6 = " + num6);
		
		
	}

}
