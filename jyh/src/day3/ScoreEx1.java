package day3;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력해 주세요 : ");
		int score = scan.nextInt();
		
		if (score >= 90 &&  score <= 100) {
			System.out.println(score + " 점수는 'A' 학점입니다.");
		}
		else if (score >= 80 && score < 90) {
			System.out.println(score + " 점수는 'B' 학점입니다.");
		}
		else if (score >= 70 && score < 80) {
			System.out.println(score + " 점수는 'C' 학점입니다.");
		}
		else if (score >= 60 && score < 70) {
			System.out.println(score + " 점수는 'D' 학점입니다.");
		}
		else if (score >= 0 && score < 60) {
			System.out.println(score + " 점수는 'F' 학점입니다.");
		}
		else {
			System.out.println(score + "점은 잘못된 점수입니다.");
		}
		
		
		
		
		
		scan.close();

	}

}
