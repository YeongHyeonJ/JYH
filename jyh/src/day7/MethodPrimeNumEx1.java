package day7;

public class MethodPrimeNumEx1 {

	public static void main(String[] args) {
		int n1 = 17;
		if(isPrime(n1))
			System.out.println(n1 + " : 소수 O");
		else
			System.out.println(n1 + " : 소수 X");

	}
	public static boolean isPrime(int n1 ) {
		
		int i;
		int count = 0;
		if(n1 <= 0) {
			return false;
		}
		for (i = 1 ; i <= n1 ; i ++) {
			if(n1 % i == 0 ) 
				count ++;
			}				
		if(count == 2) {
			return true;
		}
		return false;
		
	}
}
