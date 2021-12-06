package day3;

import java.util.Scanner;

public class ScoreEx2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력해 주세요 : ");
		int score = scan.nextInt();
		
		
		switch (score / 10) {
		case 10:
			switch(score) {
			case 100:
				System.out.println(score + " 점은 'A' 학점입니다.");
				break;
			default:
				System.out.println(score + " 점은 잘못된 점수입니다.");
			}
			break;
		case 9 :
			System.out.println(score + " 점수는 'A' 학점입니다.");
			break;
		case 8 :
			System.out.println(score + " 점수는 'B' 학점입니다.");
			break;
		case 7 :
			System.out.println(score + " 점수는 'C' 학점입니다.");
			break;
		case 6 :
			System.out.println(score + " 점수는 'D' 학점입니다.");
			break;
		case 5, 4, 3, 2, 1 :
			System.out.println(score + " 점수는 'F' 학점입니다.");
			break;
		case 0 :
			switch(score) {
			case 0,1,2,3,4,5,6,7,8,9 :
				System.out.println(score + " 점수는 'F' 학점입니다.");
			break;
			default :
				System.out.println(score + " 점은 잘못된 점수입니다.");
			}
			
			break;
		default:
		System.out.println(score + "점은 잘못된 점수입니다.");
		}
		scan.close();

		
	}

}
