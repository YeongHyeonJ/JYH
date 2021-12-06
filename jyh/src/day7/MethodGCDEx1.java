package day7;

public class MethodGCDEx1 {
	public static void main(String[] args) {
	
	int n1 = 12, n2 = 6;
	System.out.println(n1 + " , " + n2 + "의 최대공약수 : " + ngcd(n1,n2));
	System.out.println(n1 + " , " + n2 + "의 최소공배수 : " + nlcm(n1,n2));
	}
	
	
	public static int ngcd(int n1 , int n2) {
		int gcd = 0;
		for ( int i = 1 ; i <= n1 ; i ++ ) {
			if(n1 % i == 0 && n2 % i == 0){
				gcd = i;
			}
		}return gcd;
	}
	public static int nlcm(int n1 , int n2) {
		int cm = 0;
		for(int i = n1 ; i <= n1 * n2 ; i += n1 ) {	
			if(i % n2 ==0) { 
				cm = i;
				break;	
			}
		}return cm;
	}
}


