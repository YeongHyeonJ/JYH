package day13;

public class A_Shape {
	int select ; 
	int x1,y1,x2,y2, num ;
	protected int left ; 
	protected int top ;
	protected int right ; 
	protected int bottom ; 


	public A_Shape(int select, int x1, int y1, int x2, int y2, int num) {
		super();
		this.select = select;
		this.left = x1;
		this.top = y1;
		this.right = x2;
		this.bottom = y2;
		this.num = num;
	}
	public A_Shape(int x1, int y1, int x2, int y2) {
		left	= x1 < x2 ? x1 : x2 ;
		right	= x1 < x2 ? x2 : x1 ;
		top		= y1 < y2 ? y1 : y2 ;
		bottom	= y1 < y2 ? y2 : y1 ;	
		}
		//가로방향 길이right - left;
		//세로방향 길이bottom - top;	
	
	public void print() {
		System.out.println("-------도형-------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
		System.out.println("길이 : " + (right - left));
		System.out.println("길이 : " + (bottom - top));
	}
}
