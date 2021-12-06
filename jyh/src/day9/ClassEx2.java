package day9;

import java.util.Scanner;

public class ClassEx2 {

	public static void main(String[] args) {
		point2D pt1 = new point2D(1,2);
		point2D pt2 = new point2D(3,5);
		
		pt1.print();
		pt2.print();
		
		pt1.move1(1,2);
	}

}

//좌표평면에 표시할 변수 x축 값 , y 축 값
class point2D{
	String ponitName ;
	int x ;
	int y ;
	
	point2D(){ //이곳의 기본생성자는 지워도 됨, 멤버 변수는 기본 초기값이 0이기 때문에
		x = 0;
		y = 0;
	}
	point2D(int x1, int y1){
		x = x1 ;
		y = y1 ;
	}
	void print() {
		System.out.println("(" + x + "," + y + ")");
	}
	//지정된 좌표로 멤버변수 x,y를 이동시키는 메소드
	
	void move1(int x, int y) {
		Scanner scan = new Scanner(System.in);
		System.out.print("좌표 x,y 값을 입력하세요 : ");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		System.out.println("(" + (x + x1) + "," + (y + y1) + ")");
		scan.close();
	}
}