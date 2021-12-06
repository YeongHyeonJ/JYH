package day13;

public class A_Rect extends A_Shape {

	public A_Rect(int select, int x1, int y1, int x2, int y2, int num) {
		super(select, x1, y1, x2, y2, num);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		System.out.println("-------사각형-------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
		System.out.println("가로 : " + (right - left));
		System.out.println("세로 : " + (bottom - top));
	}
}
