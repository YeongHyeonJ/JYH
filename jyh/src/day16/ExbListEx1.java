package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class ExbListEx1 {

	public static void main(String[] args) {
		// 그린고등학생의 국어 영어 수학 성적 관리 리스트 작성
		ArrayList<ExbStudentList> ExbStudentList = new ArrayList<ExbStudentList>();
		Scanner scan = new Scanner(System.in);
		char next = 'y';
		while (next == 'y' || next == 'Y') {
			System.out.println("학생 정보를 입력하세요");
			System.out.print("학생 이름을 입력하세요 : ");
			String name = scan.next();
			System.out.print("국어성적을 입력하세요 : ");
			int kornum = scan.nextInt();
			System.out.print("영어성적을 입력하세요 : ");
			int engnum = scan.nextInt();
			System.out.print("수학성적을 입력하세요 : ");
			int mathnum = scan.nextInt();
			scan.nextLine();
			System.out.print("학생 성적을 더 입력하겠습니까? : ");
			next = scan.next().charAt(0);
		
			ExbStudentList.add(new ExbStudentList(name, kornum, engnum, mathnum));
		}
		System.out.println(ExbStudentList);
		scan.close();
	}
}

class ExbStudentList {
	private String student;
	private int korList;
	private int engList;
	private int mathList;

	// 맴버변수를 쉽게 초기화하기 위해서 만드는 생성자 ↓
	public ExbStudentList(String student, int korList, int engList, int mathList) {
		this.student = student;
		this.korList = korList;
		this.engList = engList;
		this.mathList = mathList;
	}

	// toString을 추가 : 맴버변수를 문자열로 쉽게 확인하기 위해서
	@Override
	public String toString() {
		return "[학생이름 : " + student + " | 한국성적 : " + korList + " | 영어성적 : " + engList + " | 수학성적 : " + mathList + "]\n";
	}

	// get / set은 외부로부터 값을 확인하거나 수정하기 위해서 작성
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public int getKorList() {
		return korList;
	}
	public void setKorList(int korList) {
		this.korList = korList;
	}
	public int getEngList() {
		return engList;
	}
	public void setEngList(int engList) {
		this.engList = engList;
	}
	public int getMathList() {
		return mathList;
	}
	public void setMathList(int mathList) {
		this.mathList = mathList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbStudentList other = (ExbStudentList) obj;
		if (engList != other.engList)
			return false;
		if (korList != other.korList)
			return false;
		if (mathList != other.mathList)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

}