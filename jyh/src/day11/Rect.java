package day11;

public class Rect {
	private Point lt ; //lefttop 왼쪽 윗점
	private Point rb ; //rightbottom 오른쪽 아래점
	
	public Point getLt() {
		return lt;
	}
	public void setLt(Point lt) {
		this.lt = lt;
	}
	public Point getRb() {
		return rb;
	}
	public void setRb(Point rb) {
		this.rb = rb;
	}
	
	public Rect(Point lt, Point rb) {
		this.lt/*<<맴버변수 색깔*/ = new Point(lt);
		this.rb/*<<맴버변수 색깔*/ = new Point(rb);
	}
	public Rect() {
		lt = new Point(0,0);
		rb = new Point(0,0);
	}
	public void move(int x, int y) {
		int width = rb.getX() - lt.getX();
		int height = rb.getY() - lt.getY();
		lt.move(x, y);
		rb.move(x + width, y + height);
	}
	public void resize(int width, int height) {
		rb.move(lt.getX() + width, lt.getY() + height);
	}
	public void print() {
		System.out.println("----사각형----");
		System.out.print("좌상점 : ");
		lt.print();
		System.out.print("우하점 : ");
		rb.print();
	}
	
	
}
