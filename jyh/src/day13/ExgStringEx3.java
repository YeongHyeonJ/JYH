package day13;

public class ExgStringEx3 {

	public static void main(String[] args) {
		/* int compareTo(String str)
		 * - equals()와 비슷
		 * - equals()는 두 문자열이 같은지 다른지만 알려줌
		 * - comparerTo는 두 문자열이 사전순으로 어떻게 되는지 알려줌
		 *  ==> 같으면 0, 다르면 음수, 양수
		 */
		String str1 = "ab";
		String str2 = new String("bt");
		String str3 = "d";
		
		System.out.println(str1 + " 은 " + str2 + " 보다 사전순으로? " + str1.compareTo(str2));
		System.out.println(str1 + " 은 " + str3 + " 보다 사전순으로? " + str1.compareTo(str3));
		System.out.println(str3 + " 은 " + str1 + " 보다 사전순으로? " + str3.compareTo(str1));
		
		
	}

}
