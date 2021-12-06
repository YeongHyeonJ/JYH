package day15;

public class ExdGenericEx1 {

	public static void main(String[] args) {
		ExdData<Integer> data1 = new ExdData<Integer>(10);
		ExdData<Double> data2 = new ExdData<Double>(1.23);
		ExdData<Double> data3 = new ExdData<Double>(3.21);
		data1.print();
		data2.print();
		if(data3 == data2) {
			System.out.println("비교 가능 같은객체");
		}else {
			System.out.println("비교 가능 다른객체");
		}
		//String이 Data<T>에 상속이 안돼서 오류
		//ExdData<String> data4;
		

	}

}
