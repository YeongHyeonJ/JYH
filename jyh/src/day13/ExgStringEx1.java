package day13;

public class ExgStringEx1 {

	public static void main(String[] args) {
		String str1 = "Hi";
		String str2 = new String("Hi");
		String str3 = "Hi";
		/* str1과 str3은 같은 지점에 있는 Hi 문자열을 공유
		 * str2는 다른지점에 Hi라는 문자열을 생성에서 사용*/
		//== 는 같은 주소에있는 값을 비교 //주소가 다르면 거짓으로 나옴
		System.out.println("같은주소인가? : " + (str1 == str2));
		System.out.println("같은주소인가? : " + (str1 == str3));
		System.out.println("같은주소인가? : " + (str2 == str3));
		//문자가 같은지 비교할때는 .equals 를 사용
		System.out.println("같은문자인가? : " + (str1.equals(str2)));
		System.out.println("같은문자인가? : " + (str1.equals(str3)));
		System.out.println("같은문자인가? : " + (str2.equals(str3)));
	}

}
