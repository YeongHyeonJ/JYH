package day2;

public class LogEx1 {

	public static void main(String[] args) {
		
		int score = 95;
		
		boolean isA = score <= 100 && score >= 90 ;
		System.out.println(score + "점은 A학점인가? " + isA);
		
		boolean driverLicense = true, registrationCard = false;
		boolean testOk = driverLicense || registrationCard ;
		
		System.out.println("시험 응시 가능? " + testOk);
		
		boolean isMale = true;
		System.out.println("남자인가? " + isMale);
		System.out.println("여자인가? " + !isMale);
		// isA = score && score; // 오류
		System.out.println();
	}
}
