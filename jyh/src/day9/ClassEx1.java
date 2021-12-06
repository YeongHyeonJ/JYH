package day9;

public class ClassEx1 {

	public static void main(String[] args) {
		Car car1 = new Car(1, "현대", "소형");
		System.out.println("브랜드 : " + car1.brand);
		car1.turnOn();
		
		Car car2 = new Car(6, "기아", "SUV");
		System.out.println("브랜드 : " + car2.brand);
		Car car3 = car1;
		System.out.println("브랜드 : " + car3.brand);
		car3.type = "대형";
		System.out.println("차종 : " + car1.type);
		System.out.println(car1.count + "인승");
		//기본 생성자를 제공하지 않은 Scanner 클래스
		//Scanner scan = new Scanner();
		
	}
}

class Car{
	String brand;	// 브랜드 정보
	String type;	// 타입 정보
	int count;		// 탑승인원 정보
	int power;		// 시동 종류
	int speed; 		// 속력
	//자동차와 관련된 기능들 => 멤버 메소드
	//시동 켜는 기능
	
	void turnOn() {System.out.println("켰습니다.");}
	void turnOff() {System.out.println("껐습니다.");}
	//Car(){} //생성자가 하나도 없으면 이 코드가 생성됨
	Car(int count1, String brand1, String type1 ){
		count = count1;
		brand = brand1;
		type = type1;
		
	}
}
