package day9;

public class CalssEx3 {

	public static void main(String[] args) {
		
		high std = new high("그린고등" , 1, 1, 1, "홍길동");
		
		std.print();

	}
}

class high {
	String schoolname ; //학교 명
	int grade ;			//학년
	int classnum ; 		//반
	int num ; 			//번호
	String Name ;		//이름

	
	public high(){
		/*schoolname = "고등학교";
		grade = 1 ;
		classnum = 1;
		num = 1 ;
		Name = "" ;*/
		this("고등학교", 1, 1, 1, "");
		System.out.println("this()");
	}
	
	high(String schoolname, int grade, int classnum, int num, String name) {		
		this.schoolname = schoolname;
		this.grade = grade;
		this.classnum = classnum;
		this.num = num;
		this.Name = name;

	}

	void print() {
		System.out.println(schoolname + "학교");
		System.out.println(grade + "학년 입니다.");
		System.out.println(classnum + "반 입니다.");
		System.out.println(num + "번 입니다.");
		System.out.println("이름은 " + Name + " 입니다.");
		
	}
}
