package day11;

public class ClassProtectedEx1 {

	public static void main(String[] args) {
		C c = new C();
		c.a = 1;
		c.b = 2;
		c.c = 3;
		//c.d = 4; //해당 클래스 내에서만 써야됨 P안에서만

	}
}
class P{
	public int a ;
	protected int b;
	int c;
	private int d;
}
class C extends P{
	public C() {
		a = 1;
		b = 2;
		c = 3;
		//d = 4; //P클래스가 아니기 때문에 사용 불가능
	}
}