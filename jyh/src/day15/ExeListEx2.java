package day15;

import java.util.ArrayList;

public class ExeListEx2 {

	public static void main(String[] args) {
		ExePoint pt = new ExePoint(0, 0);
		ArrayList<ExePoint> moveRoute = new ArrayList<ExePoint>();
		moveRoute.add(new ExePoint(pt));
		System.out.println(moveRoute);
		pt.move(5, 5);
		moveRoute.add(new ExePoint(pt));
		pt.move(10, 10);
		moveRoute.add(new ExePoint(pt));
		System.out.println(moveRoute);
		System.out.println(pt + "좌표가 있는가? : " + moveRoute.contains(pt));
	}
}

class ExePoint{
	int x, y;
	
	public ExePoint(int x, int y) {
		this.x = x;		this.y = y;
	}
	public ExePoint(ExePoint p) {
		this.x = p.x;		this.y = p.y;
	}
	public void move(int x, int y) {
		this.x = x; 	this.y = y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExePoint other = (ExePoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}