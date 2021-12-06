package day10;

public class ClassStaticEx1 {

	public static void main(String[] args) {
		//System.out.println("객체 변수 num : " + Test1.num1);
		System.out.println("클래스 변수 num : " + Test1.num2);
		Test1 t;
		Test1 t1 = new Test1();
		System.out.println("객체 변수 num : " + t1.num1);
		System.out.println("클래스 변수 num : " + t1.num2);
		t1.num1 = 20;
		t1.num2 = 40;
		System.out.println("객체 변수 num : " + t1.num1);
		System.out.println("클래스 변수 num : " + t1.num2);
		t1.print1();
		t1.print2();
		System.out.println(Math.E);
		System.out.println(Math.PI);
		System.out.println(Math.random());
	}
}

class Test1{
	public int num1 = 1;				//객체 변수
	public static int num2 = 2;			//클래스 변수
	public void print1() {
		System.out.println("num1 : " + num1 ); //1번 가능
		System.out.println("num1 : " + num2 ); //2번 가능
		method1();	//3번 가능
		method2();	//4번 가능
	
		System.out.println("객체 메소드");
	}
	
	public static void print2() {
		//System.out.println("num1 : " + num1 ); //5번 불가능
		System.out.println("num1 : " + num2 ); //6번 가능
		//method1();	//7번 불가능
		method2();	//8번 가능
		System.out.println("클래스 메소드");
	}
	public void method1() {}			//객체 메소드
	public static void method2() {}		//클래스 메소드
}