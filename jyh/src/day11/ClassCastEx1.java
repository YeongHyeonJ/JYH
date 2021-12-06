package day11;

public class ClassCastEx1 {

	public static void main(String[] args) {
		int num = 2;
		P2 p1 = new P2();
		P2 p2 = p1;
		
		C2 c = new C2();
		P2 p = new P2();
		//자식 클래스의 객체를 부모 클래스의 객체로 자동 형변환이 된다.
		P2 parent = new C2();
		//P2에 hello 메소드가 없기에 호출 불가능
		//parent.hello();
		C2 child1 = new C2();
		P2 parent2 = child1;
		parent2.print();
		/* [전부 안되는 경우] ==> 부모를 통해서 만들었기 때문에
		C2 child3 = (C2) new P2(); //안되는 경우 : 부모클래스로 객체를 만들어서 형변환하는 경우
		P2 parent3 = new P2();
		C2 child4 = (C2) parent3;
		child3.print();
		*/
		
		//조건부로 (명시적)가능한 경우 : 자식클래스로 객체를 만들어서 부모 클래스로 형변환한 경우
		P2 parent5 = new C2();
		C2 child5 = (C2)parent5;
		child5.hello();
	}
}

class P2{
	void print() {
		System.out.println("부모입니다.");
	}
}
class C2 extends P2{
	void hello() {
		System.out.println("안녕하세요.");
	}
}