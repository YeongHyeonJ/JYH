package day4;

public class ForLCMEx1 {

	public static void main(String[] args) {
		int i , num1 = 8 ,num2 = 12 , CM ;
		for(i = 1 ; i <= num1 * num2 ; i ++ ) {	
			if(i % num1 == 0 && i % num2 ==0) { 
		System.out.println(i);
		break;
			}
		}
	}

}
