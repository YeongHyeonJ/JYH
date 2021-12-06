package day9;

public class MethodArithmeticEx1 {

	public static void main(String[] args) {
		/*두 정수와 산술연산자가 주어졌을때 결과 출력
		 * 
		 */
		System.out.println("결과값 : " + ArithmeticEx2(4,7,'+'));
		System.out.println("결과값 : " + ArithmeticEx2(4,7,'-'));
		System.out.println("결과값 : " + ArithmeticEx2(4,7,'*'));
		System.out.println("결과값 : " + ArithmeticEx2(4,7,'/'));
		System.out.println("결과값 : " + ArithmeticEx2(4,7,'%'));
		
	}
	
	public static double ArithmeticEx1(double num , double num2 , char x){
		double art = 0;
			if(x=='+') {
				art = num + num2;	
			}
			if(x=='-') {
				art = num - num2;
			}
			if(x=='*') {
				art = num * num2;
			}
			if(x=='/') {
				art = num / num2;
			}
			if(x=='%') {
				art = num % num2;
			}
		
		return art;
	}
	
	public static double ArithmeticEx2(int num, int num2 , char op ){
			
			switch(op) {
			case '+' : return num + num2;	
			case '-' : return num - num2;
			case '*' : return num * num2;
			case '/' : return (double)num / num2;
			case '%' : return num % num2;
			default : return 0;
			}
	}
	public static double ArithmeticEx3(int num , char op , int num2){
		double res = 0.0;
		switch(op) {
		case '+' : res = num + num2; 	break;	
		case '-' : res = num - num2;	break;
		case '*' : res = num * num2;	break;
		case '/' : res = (double)num / num2;	break;
		case '%' : res = num % num2;	break;
		default : res = 0;
		}
		return res;
	}
}
