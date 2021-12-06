package day13;

public class ExcTestEx1 {

	public static void main(String[] args) {
		/* 추상 클래스는 추상클래스를 이용하여 객체를 만들 수 없다.*/
		//추상클래스로 바로 객체생성은 오류
		//자식클래스로 객체생성은 활용 가능
		//ExcP p = new ExcP(); ==> 불가능
		ExcP p = new ExcC();
		p.test();
	}

}

abstract class ExcP{
	public abstract void test();
}
class ExcC extends ExcP{
	@Override
	public void test() {
		System.out.println("추상 메소드");
	}
}