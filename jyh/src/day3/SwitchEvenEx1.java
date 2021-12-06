package day3;

public class SwitchEvenEx1 { //스위치문 사용 홀짝

	public static void main(String[] args) {
		
		int num = 10;
		switch(num % 2) {
		case 0:
			System.out.println(num + " : 짝수");
			break;
		default:
			System.out.println(num + " : 홀수");
		}
	}

}
