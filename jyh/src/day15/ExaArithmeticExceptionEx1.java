package day15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExaArithmeticExceptionEx1 {
	// 두 정수의 산술연산자를 입력받아 산출연산 결과출력
	// 메소드를 이용, 예외처리를 해야함
	public static void main(String[] args) throws Exception {
	Scanner scan = new Scanner(System.in);
	int num1;
	int num2;
	char op;
	double res = 0.0;
	System.out.print("두 정수와 산술 연산자를 입력하세요 (예 : 1 + 2) : ");
		try {
			num1 = scan.nextInt();
			op = scan.next().charAt(0);
			num2 = scan.nextInt();
			res = arithmetic(num1, op, num2);
		
			System.out.println(""+ num1 + op + num2 + "=" + res);
		
		
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘못했다 ");
		}
		scan.close();
	}
	public static double arithmetic(int num1, char op, int num2) 
			throws Exception {
		double res = 0.0;
		switch(op) {
		case '+':	res = num1 + num2; 			break;
		case '-':	res = num1 - num2; 			break;
		case '*':	res = num1 * num2; 			break;
		case '/':	res = num1 / (double)num2; 	break;
		case '%':	res = num1 % num2; 			break;
		default :	throw new Exception("잘못된 연산자입니다.");
		}
		return res;
	}
}
