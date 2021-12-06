package day11;


public class PolymorphismEx1 {

	public static void main(String[] args) {
		Phone p = new Phone();
		SmartPhone sp = new SmartPhone();
		FolderPhone fp = new FolderPhone();
		calling(p);
		calling(sp);
		calling(fp);
		Human h1 = new Human(p);
		Human h2 = new Human(sp);
		Human h3 = new Human(fp);
		h1.p.get();
		h2.p.get();
		h3.p.get();
		
	}
	//매개변수의 다형성 : 매개변수 객체들의 공통이 되는 부모로 설정
	public static void calling(Phone p) {
		p.call();
	}
}
class Human{
	Phone p;
	public Human(Phone p) {
		this.p = p;
	}
}

class Phone{
	public String phoneNum;
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void call() {
		System.out.println("전화를 거는 중입니다.");
	}
	public void get() {
		System.out.println("전화를 받는 중입니다.");
	}
}

class SmartPhone extends Phone{
	public void touch() {
		System.out.println("액정 터치");
	}
}

class FolderPhone extends Phone{
	public void fold() {
		System.out.println("핸드폰 접기");
	}
}