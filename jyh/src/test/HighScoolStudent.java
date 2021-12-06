package test;

public class HighScoolStudent {

	public static void main(String[] args) {
		HighStudent st = new HighStudent("그린고등학교", "홍길동", 1, 1, 1);
		st.print();
		

	}

}

class HighStudent {
	String schoolname, studentname;
	int grade, classnum, num;
	
	public HighStudent(String schoolname, String studentname, int grade, int classnum, int num) {
		this.schoolname = schoolname;
		this.studentname = studentname;
		this.grade = grade;
		this.classnum = classnum;
		this.num = num;
	}
	
	
	public void print() {
		System.out.println("학교	: " + schoolname);
		System.out.println("이름	: " + studentname);
		System.out.println("학년	: " + grade);
		System.out.println("반	: " + classnum);
		System.out.println("번호	: " + num);
	}
	
	
}
