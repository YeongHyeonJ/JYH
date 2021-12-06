package day10;

public class Rect {
	int x1,y1;
	int x2,y2;
	
	public Rect() {
		
	}
	public Rect(int x1,int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	void print(int x1,int y1, int x2, int y2) {
		System.out.println("(x,y)");
		System.out.println("A : (" + x1 + "," + y1 + ")");
		System.out.println("B : (" + x1 + "," + y2 + ")");
		System.out.println("C : (" + x2 + "," + y1 + ")");
		System.out.println("D : (" + x2 + "," + y2 + ")");
	}
}
