package day13;

public class A_Ellipse extends A_Shape{


	public A_Ellipse(int select, int x1, int y1, int x2, int y2, int num) {
		super(select, x1, y1, x2, y2, num);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		System.out.println("-------타원-------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
		System.out.println("길이 : " + (right - left));
		System.out.println("길이 : " + (bottom - top));
	}
}
