package day13;

public class ExgStringLengthEx1 {

	public static void main(String[] args) {
		/* int length() : 문자열 길이를 알려주는 메소드 */
		String str = "Hello world";
		System.out.println(str + "의 문자열 길이 : " + str.length());
		
		String str1 = "ababcdeabfghiabjklasbmnoabp";
		String search = "ab";
		int index = 0;
		int count = 0;
		do {
			index = str1.indexOf(search, index);
			if(index >= 0) {
				count++;
				index = index + search.length();
			}
		}while(index != -1);
		System.out.println(count);
	}

}
