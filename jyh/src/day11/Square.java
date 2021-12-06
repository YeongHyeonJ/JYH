package day11;
//직사각형 클래스(Rect)를 상속받음
public class Square extends Rect {
	
	int side;
	
	public Square() {
		/* lt는 부모의 멤버변수이지만 private로 되어 있기에
		 * 물려받을 수는 있어도 직접 접근할 수 없다.*/
		
		// lt/*맴버변수 색깔*/ = new Point(0,0);
		//Point tmp = new Point(10,10);
		
		/* public으로 된 setter를 이용하요 lt에 접근하여야 한다.*/ 
		
		//setLt(tmp);
	}
	
	public Square(Point pt, int side) {
		//pt 를 lt에 저장
		//lt = pt; >> private라 불러올 수 없음.
		//setLt(pt) ; >> lt 외 밖에서 알려준 pt를 공유해서 쓰면 안됨.
		Point tmp = new Point(pt);
		setLt(tmp);
		//side 를 멤버변수 side에 저장
		this.side = side;
	}
	//resize는 메소드 오버로딩
	public void resize(int side) {
		this.side = side;
	}
	
	@Override
	//Rect에서 물려받은 print() 메소드를 재정의 
	public void print() {
		
		System.out.println("----정사각형----");
		System.out.print("시작점 : ");
		//lt의 print 기능 호출
		getLt().print();
		System.out.println("한 변의 길이 : " + side);
	}
}
