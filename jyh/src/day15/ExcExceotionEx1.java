package day15;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcExceotionEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int arr[] = new int[5];
		inputArray(scan, arr);
	}
	public static void inputArray(Scanner scan, int arr[]) {
		//배열이 없는경우 예외 발생
		if(arr == null) {
			throw new NullPointerException("배열이 만들어지지 않았습니다.");
		}
		if(scan == null) {
			throw new NullPointerException("스캐너가 만들어지지 않았습니다.");
		}
		System.out.println("정수를 " + arr.length + "개 입력하세요 : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		int arrnum =0;
		int fixnum =0;
		do{ 
			try {
				System.out.println("수정할 번지와 정수를 입력하세요 : ");
				arrnum = scan.nextInt();
				fixnum = scan.nextInt();
				arr[arrnum] = fixnum;				
				System.out.println(Arrays.toString(arr));
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("입력을 잘못했다 ");
			}
		}while(arrnum >= 0);
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}
}
