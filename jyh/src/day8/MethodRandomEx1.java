package day8;
import java.util.Random;
public class MethodRandomEx1 {

	public static void main(String[] args) {
		int Min = 1;
		int Max = 10;
		Random(Min,Max);
	}
	
	public static void Random(int Min , int Max) {

		Random r = new Random();
		
		if(Min <= 0 ) {
			System.out.println("최소값이 잘못 입력되었습니다.");
		}
		else {
			int random = (int)(Math.random()*(Max-Min+1)+Min);
			System.out.print(random + " "); 
		}
		
	}
	
	

}
