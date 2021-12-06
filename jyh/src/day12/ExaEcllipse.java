package day12;

public class ExaEcllipse extends ExaShape {
	
	public ExaEcllipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
	@Override
	public void print() {
		System.out.println("-------타원-------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
		System.out.println("가로지름 : " + getWidth());
		System.out.println("세로지름 : " + getHeight());
	}
	public void testE() {
		System.out.println("타원");
	}
}
