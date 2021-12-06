package day13;

public class ExfTestEx1 {

	public static void main(String[] args) {
		ExfShape [] r = new ExfShape[3];
		r[0] = new ExfEllipse(0, 3, 3, 0);
		r[1] = new ExfRect(0, 0, 1, 1);
		r[2] = new ExfRect(2, 2, 0, 0);
		
		for(ExfShape tmp : r) {
			tmp.shapeDraw();
		}
	}

}
/*도형 크기변경 , 도형 이동, 도형그리기 Draw 인터페이스*/
