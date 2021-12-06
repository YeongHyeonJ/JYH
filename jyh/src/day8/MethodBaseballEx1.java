package day8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MethodBaseballEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 9, size = 3;
		int strike = 0;
		int ball = 0;
		int user [] = new int[3];
		int com[] = randomArray(min,max,size);

		
		System.out.print("컴퓨터 숫자가 입력되었습니다");
		System.out.println();
		
		do				
		{
			System.out.print("선택번호 : ");
			inputArray(user, scan);
			
			
			strike = getStrike(com,user);			
			
			
			ball = getBall(com, user);				
		
		
			printResult(strike, ball);
		}
		while(strike !=3);
		System.out.println("정답입니다. 프로그램을 종료합니다.");
		scan.close();
	}

	//1. 1~9의 숫자를 랜덤으로 3가지 생성하여 배열에 저장.
	//2. 사용자의 숫자 3가지를 입력하여 배열에 저장.
	//3. 두 배열을 비교
	//4. 비교한 값에 따라 결과를 출력
	
	public static int [] randomArray(int min , int max , int size) {
		int [] arr = new int[size];
		for(int count = 0; count<size; ) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//random과 배열을 비교하여 중복된 숫자가 없으면
			if(!containsArray(arr, random, count)) {
				arr[count++] = random;
			}
		}		
		return arr;
	}
	
	public static boolean containsArray(int []arr, int num, int n) {
		//배열의 길이보다 검사하는 갯수가 많으면 검사 갯수를 배열의 길이로,
		//아니면 원래 검사 개수로 변경
		n = arr.length < n ? arr.length : n;
		for(int i = 0; i<n; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static int check(int []arr1, int []arr2) {
		int count = 0;
		for( int tmp : arr1) {
			if(containsArray(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count;
	}
	
	
	public static int getStrike(int []com, int []user) {
		int count = 0;
		for(int i = 0; i < com.length; i++) {
			if(com[i] == user[i]) {
				count ++;
			}
		}
		return count;
	}
	public static int getBall(int []com, int []user) {
		int count = 0;
		for(int tmp : com) {
			if(containsArray(user, tmp, user.length)) {
				count++;
			}
		}
		return count - getStrike(com, user);
	}
	
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3O");
		}
		System.out.println();
	}
	
	public static void inputArray(int []arr, Scanner scan) {
		
		
		for(int i = 0; i < arr.length ; i++) {
			arr[i] = scan.nextInt();
		}
		
		
	}
}


