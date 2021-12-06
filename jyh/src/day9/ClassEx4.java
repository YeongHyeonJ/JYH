package day9;

public class ClassEx4 {

	public static void main(String[] args) {

		String sName = "그린고등학교", name = "홍길동" ;
		int grade = 1, classNum = 1, num = 1;
		System.out.println(sName + "학교");
		System.out.println(grade + "학년 입니다.");
		System.out.println(classNum + "반 입니다.");
		System.out.println(num + "번 입니다.");
		System.out.println("이름은 " + name + " 입니다.");
		
		high std = new high("그린고등" , 1, 1, 1, "홍길동");
		std.print();
		high std1 = new high("그린고등" , 1, 1, 2, "임꺽정");
		std1.print();
	}
}
