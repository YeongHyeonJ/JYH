package day9;

public class MethodOverloadingEx1 {

	public static void main(String[] args) {
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1.2,2.2));
		System.out.println(sum(1,2.6));
		System.out.println(1);
		System.out.println('1');
		System.out.println("1");
	}
	
	public static int sum(int num1 , int num2) {
		System.out.println("메소드 1");
		return num1 + num2;
	}

	public static int sum(int num1 , int num2 , int num3) {
		System.out.println("메소드 2");
		return num1 + num2 + num3;
	}

	public static double sum(double num1 , double num2) {
		System.out.println("메소드 3");
		return num1 + num2;
	}
	/* 안되는 경우 : 리턴타입만 다를때
	public static double sum(int num1 , int num2) {
		return num1 + num2;
	}
	*/
}
