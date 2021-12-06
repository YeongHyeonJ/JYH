package day9;

public class ClassAccessEx1 {

	public static void main(String[] args) {
		A a = new A();
		//a.num1 = 10; //num1 은 private 접근 제한자이기에 class가 달라 사용 불가능
		a.setNum1(10);
		a.num2 = 20;
		a.num3 = 30;

	}

}

class A{
	private int num1;
	int num2; 			//(default) : 기본(접근 제한자를 생략)
	public int num3;
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}

}