package day11;

public class Point {
	private int x,y;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//복사 생성자 
	public Point(Point pt) {
		this.x = pt.x;
		this.y = pt.y;
	}
	//좌표 이동기능
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//좌표를 출력하는 기능
	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}
}
