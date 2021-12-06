package day11;

public class FinalEx1 {
	public final static double PI = 3.14; //final이기 때문에 수정 불가능
	public static void main(String[] args) {
		System.out.println(PI);
		// PI = 3.141592; //정수를 수정하려했기 때문에 에러

	}

}
final class Test11_1{}
//final 클래스이기 때문에 상속받을 수가 없다.
//class Test11_2 extends Test11_1{}
class Test11_3{
	public final void print() {
		
	}
}
class Test11_4 extends Test11_3{
	// @Override
	// public void print() {} // final 메소드를 오버라이딩 하려 했기 때문에 에러
}