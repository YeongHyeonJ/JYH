package day13;

public interface ExfDraw {
	public void shapeDraw();
	public void resize(int width, int height);
	public void move(int x, int y);
}

abstract class ExfShape implements ExfDraw{
	protected int left, right, top, bottom;

	@Override
	public void resize(int width, int height) {
		right = left + width;
		bottom = top + height;
		
	}

	@Override
	public void move(int x, int y) {
		int width = right - left;
		int height = bottom - top;
		left = x;
		top = y;
		right = x + width; 
		bottom = y + height;
		
	}
	
	public ExfShape(int x1, int y1, int x2, int y2) {
		left	= x1 < x2 ? x1 : x2 ;
		right	= x1 < x2 ? x2 : x1 ;
		top		= y1 < y2 ? y1 : y2 ;
		bottom	= y1 < y2 ? y2 : y1 ;
		
	}
}



