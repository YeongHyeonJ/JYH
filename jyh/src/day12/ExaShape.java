package day12;

import day11.Point;
//커서로 끌어내는 좌표는 항상 사각형 기준
//사각형 안의 도형을 점의 개수에 따라 도형 생성
//각 변의 길이는 전부 일치하지 않음 // 삼각형 육각형 별 등등
public class ExaShape {
	//도형 클래스를 만들어야한다.

	protected int left ; 
	protected int top ;
	protected int right ; 
	protected int bottom ; 

	public ExaShape(int x1, int y1, int x2, int y2) {
		left	= x1 < x2 ? x1 : x2 ;
		right	= x1 < x2 ? x2 : x1 ;
		top		= y1 < y2 ? y1 : y2 ;
		bottom	= y1 < y2 ? y2 : y1 ;
		
	}
	//가로방향 길이
	public int getWidth() {
		return right - left;
	}
	//세로방향 길이
	public int getHeight() {
		return bottom - top;
	}
	//도형의 위치 이동
	public void move(int left, int top) {
		this.right = left + getWidth();
		this.bottom = top + getHeight();
		this.left = left;
		this.top = top;
		
	}
	//도형 크기를 바꾸기
	//direction : 1 > 우하방향 , 2 > 좌하방향 , 3 > 좌상방향 , 4 > 우상방향
	public void resize(int width, int height, int direction) {
		if(width <= 0 || height <= 0) {
			System.out.println("잘못된 수치입니다.");
			return ;
		}
		switch(direction) {
		case 1: 
			right	= left	+ width		;
			bottom	= top + height		;
			break;
		case 2:
			left	= right	- width		;
			bottom	= top + height		;
			break;
		case 3: 
			left	= right	- width		;
			top		= bottom - height	;
			break;
		case 4: 
			right	= left	+ width		;
			top		= bottom - height	;
			break;
		default: System.out.println("잘못된 방향입니다.");
		}
	}
	public void print() {
		System.out.println("-------도형-------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
	}
	
	public void testS() {
		System.out.println("도형");
	}
}