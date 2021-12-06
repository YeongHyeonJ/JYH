package day11;

public class ClassInitEx1 {

	public static void main(String[] args) {
		Test11 t = new Test11();
		System.out.println(t.num);
		System.out.println(t.cnt);
	}
}

class Test11{
	//객체 맴버변수 num의 초기화 순서
	public int num = 10;
	{
		num/*맴버변수 색깔*/ = 20;
	}
	public Test11() {
		num = 30;
	}
	
	//클래스 맴버변수 cnt의 초기화 순서
	public static int cnt = 11 ;
	static {
		cnt = 21; //초기화 블록
	}
	
}