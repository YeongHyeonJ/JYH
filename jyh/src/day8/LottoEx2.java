package day8;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


public class LottoEx2 {

	public static void main(String[] args) {
		
		int min = 1, max = 7;
		int [] lotto = randomArray(min,max,6);
		int bonus = createbonus(min, max, lotto );	
		System.out.print(Arrays.toString(lotto));
		System.out.println();
		System.out.println(" 보너스 번호 : " + bonus);
		Scanner scan = new Scanner(System.in);
		
		int [] user = new int[6];
		System.out.print("선택번호 : ");
		for(int i = 0; i < user.length ; i++) {
			user[i] = scan.nextInt();
		}
		
		scan.close();
		System.out.println(check(lotto,user));
		rank(lotto, bonus, user);
		
	}

	public static int [] randomArray(int min, int max, int size) {
		int []arr = new int [size];
		for(int count = 0; count<size; ) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//random과 배열을 비교하여 중복된 숫자가 없으면
			if(!containsArray(arr, random, count)) {
				arr[count++] = random;
				
				//count 뒤에있는 ++ 은 random값을 저장한 후에 1 증가
				//그래서 arr[count] = random ; count ++ 이 된다.
			}
		}
		return arr;
	}	
	
	//arr배열에 있는 숫자를 num 숫자와 n번째 열까지 비교
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
	/* 기능 : 배열의 갯수가 주어지면 min~max사이의 랜덤한 정수를 중복되지 않게 생성하여
	 *       저장하는 매소드
	 * 매개변수 : 배열의 갯수, 최소값, 최대값 => int min, int max, int size 
	 * 리턴타입 : 랜덤한 수가 저장된 배열 => int []
	 * 메소드명 : randomArray
	 * */
	
	public static int createbonus(int min, int max, int[]arr) {
		
		int bonus = 0;
		while(true) {
			bonus = (int)(Math.random()*(max-min+1)+min);
			if(containsArray(arr, bonus, arr.length)) {
				continue;
			}
			break;
		}
		return bonus;
	}
	//두가지의 배열을 불러와 containsArray로 연결
	public static int check(int []arr1, int []arr2) {
		int count = 0;
		for( int tmp : arr1) {
			if(containsArray(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count;
	}
	
	public static void rank(int[]lotto, int bonus, int []user) {
		int count = check(lotto, user);
		String result = "";
		switch(count) {
		case 6 : result = "1등 당첨!!";
			break;
		case 5 : result = containsArray(user, bonus, user.length) ?
					"2등 당첨!!" : "3등 당첨!!" ;
			break;
		case 4 : result = "4등 당첨!!";
			break;
		case 3 : result = "5등 당첨!!";
			break;
		default : result = "꽝";			
		}
		System.out.println(result);
	}
	
}

