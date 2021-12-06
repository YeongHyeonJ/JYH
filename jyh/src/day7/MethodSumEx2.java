package day7;


public class MethodSumEx2 {

	public static void main(String[] args) {
		sumAll1();
		sumAll2(10);
		sumAll3(31 , 40);
		int begin = 1, end =10;
		System.out.println(begin + "부터 " + end + "까지 합 : " + sumAll4(begin,end));
		int sum = sumAll4(1,10) + sumAll4(21,30);
		System.out.println("1에서 10까지의 합과 2에서 30까지의 합을 더한 값 : " + sum);
	}
	
	public static void sumAll1() {
		int begin = 1, end = 10;
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		System.out.println(begin + "부터 " + end + "까지 합 : " + sum);	
	}
	
	public static void sumAll2(int end) {
		int begin = 1 ;
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		System.out.println(begin + "부터 " + end + "까지 합 : " + sum);		
	}

	public static void sumAll3(int begin , int end) {
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		System.out.println(begin + "부터 " + end + "까지 합 : " + sum);		
	}
	
	public static int sumAll4(int begin , int end) {
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		return sum;	
	}
	
}
