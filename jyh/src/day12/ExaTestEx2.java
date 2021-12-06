package day12;

public class ExaTestEx2  {

	public static void main(String[] args) {
		int size = 10;
		ExaShape arr[] = new ExaShape[size];
		arr[0] = new ExaEcllipse(0, 0, 10, 10);
		arr[1] = new ExaRect(10, 10, 20, 20);
		arr[2] = new ExaRect(10, 15, 20, 25);
		arr[3] = new ExaShape(10, 10, 0, 0);
		//ExaShape 클래스가 초기값 설정 없을때 타입에 맞는 초기값을 설정함
		//참조변수는 초기값이 null
		//초기값(null)이 아니면 저장하는 if문
		for(int i = 0; i < arr.length ; i ++) {
			if(arr[i] != null) {
				arr[i].print();
			}
		}
		//위에서 저장된 arr 값을 부모클래스(ExaShape) tmp값에 저장
		for(ExaShape tmp : arr){
			//저장된 tmp 값이 초기화값 numm 이 아니면 실행
			if(tmp != null) {
				// tmp가 ExaEcllipse를 불러오는 값이면 실행
				if(tmp instanceof ExaEcllipse) {
					//tmp는 ExaShape값이므로 앞에(ExaEcllipse)를 붙여 형변환 해준다.
					((ExaEcllipse) tmp).testE();
				}
				else if(tmp instanceof ExaRect) {
					((ExaRect) tmp).testR();
				}
			}
		}
		System.out.println("--------------------------------");
		for(ExaShape tmp : arr) {
			if(tmp == null) {
				continue;
			}
			print(tmp);
		}
	}
	
	//매개변수가 사각형이면 사각형 출력, 원이면 원, 도형이면 도형
	public static void print(ExaShape shape) {

		if(shape != null) {
			if(shape instanceof ExaRect) {
				System.out.println("사각형");
			}
			else if(shape instanceof ExaEcllipse) {
				System.out.println("타원");
			}
			else {
				System.out.println("도형");
			}
		}
	}
	
}
