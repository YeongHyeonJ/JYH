package day10;

public class Ecllips {
	private int x,y;
	private int rlRadius, udRadius ;
	
	public Ecllips() {
		
	}
	public Ecllips(int x, int y, int rlRadius, int udRadius) {
		this.x = x;
		this.y = y;
		this.rlRadius = rlRadius;
		
		this.udRadius = udRadius;
		
	}
	void ecprint(int x, int y, int rlRadius, int udRadius) {
		System.out.println("중심점 : (" + x + "," + y + ")");
		int verticality = udRadius * 2;
		int horizontal = rlRadius * 2;
		int top = y + udRadius;
		int bottom = y - udRadius;
		int right = x + rlRadius;
		int left = x - rlRadius;
		
		System.out.println("원의 수직 지름 거리 : " + verticality );
		System.out.println("원의 수평 지름 거리 : " + horizontal );
		System.out.println("원의 윗점 : (" + x + "," + top + ")" );
		System.out.println("원의 아랫점 : (" + x + "," + bottom + ")" );
		System.out.println("원의 오른점 : (" + right + "," + y + ")" );
		System.out.println("원의 왼점 : (" + left + "," + y + ")" );
	}
}
