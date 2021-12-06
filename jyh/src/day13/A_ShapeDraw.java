package day13;

import java.util.Scanner;

public class A_ShapeDraw {
		//도형 클래스를 만들어야한다.

	
	private A_Shape [] drawList ;
	private A_Shape [] tmp = new A_Shape[10];
	private int count;
	private static Scanner scan;
	
	public A_ShapeDraw() {
		this(10,scan);
		//boardList = new Board[10];
		//this.scan = scan;
	}
	public A_ShapeDraw(int size,Scanner scan) {
		this.scan = scan;
		if(size > 10) {
			drawList = new A_Shape[size];
		}else {
			drawList = new A_Shape[10];
		}
	}
	
	public void insertSahpe() {
		scan.nextLine(); //메뉴에서 입력된 엔터를 처리
		System.out.print("도형을 선택하세요(1. 사각형 2. 타원 : ");
		int select = scan.nextInt();
		//위에서 입력한 엔터를 처리
		System.out.print("점 두개를 입력하세요(ex : 1 2 3 4 => (1,2) (3,4)) : ");
		int x1	= scan.nextInt();
		int y1	= scan.nextInt();
		int x2	= scan.nextInt();
		int y2	= scan.nextInt();
		switch(select) {
			case 1 : System.out.println("사각형을 그렸습니다."); break;
			case 2 : System.out.println("타원을 그렸습니다."); break;	
		default:System.out.println("잘못 입력하였습니다.");
		}
		if(select == 1){
			drawList[count] = new A_Rect(select, x1, y1, x2, y2, count + 1);
			count++;
		}
		else if(select == 2){
			drawList[count] = new A_Ellipse(select, x1, y1, x2, y2 ,count + 1);
			count++;
		}
	}
		
	public void againShape() {	
		//cancelShape에 저장되어있는 tmp를 불러와서 다시 배열에 저장한다.
		for(int i = 0 ; i < drawList.length ; i++) {
			if(tmp[i] != null) {
			drawList[i] = tmp[i] ;
			}
		}
		System.out.println("다시 실행하였습니다.");
	}
	
	public void cancelShape() {	
		for(int i = 0; i <drawList.length ; i++) {
				if(drawList[i] != null) {
					tmp[i] = drawList[i];					
				}else {
					drawList[i-1] = null;
				}
		}
		System.out.println("실행을 취소하였습니다.");
	}
	
	public void displayShape(){
		for(int i = 0 ; i < drawList.length ; i++) {
			if(drawList[i] != null) {
			drawList[i].print();
			}
		}
	}
	
}