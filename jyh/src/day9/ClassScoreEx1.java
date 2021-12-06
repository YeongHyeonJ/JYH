package day9;

import java.util.Scanner;

public class ClassScoreEx1 {

	public static void main(String[] args) {
		//정보를 입력할 수 있는 5칸의 배열을 생성
		Score sc[] = new Score[5];
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < sc.length ; i ++) {
			//new를 통해 정보를 생성하고, 생성자로 초기화
			System.out.println("이름 : ");
			String name = scan.next();
			System.out.print("국어 : ");
			int korean = scan.nextInt();
			System.out.print("영어 : ");
			int english = scan.nextInt();
			System.out.print("수학 : ");
			int math = scan.nextInt();
			sc[i] = new Score(korean,english,math,name);
		}	//위의 for문으로 i값을 0부터 증가시켜 0번지부터 4번지까지의 5개 배열에 sc값을 저장
		
		for(Score tmp : sc) { 	//향상된 for문으로 sc에있는 값을 tmp에 저장하고 반복
			tmp.print();		//tmp값에 저장된 값을 Score 클래스에 있는 print로 출력
		}
		scan.close();
	}
}
/* 국어 영어 수학 성적을 관리하기 위한 클래스를
 * 학생 5명의 성적을 관리하기 위한 배열*/

// 국어 영어 수학 성적의 클래스 생성
// 과목당 5명의 성적을 입력

class Score{
	String name;
	int korean;
	int english;
	int math;
	
	public Score() {
		String name = "";
		korean = 0;
		english = 0;
		math = 0;
	}
	public Score(int korean, int english, int math, String name) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	void print() {
		System.out.println("이름 : " + name);
		System.out.println("국어 성적 : " + korean);
		System.out.println("영어 성적 : " + english);
		System.out.println("수학 성적 : " + math);
	}
	
}
