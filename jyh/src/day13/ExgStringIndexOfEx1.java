package day13;

public class ExgStringIndexOfEx1 {

	public static void main(String[] args) {
		/* int indexOf(int ch) : 문자가 몇번지에 있는지 알려주는 메소드
		 * 없으면 -1 을 알려줌*/

		String str = "Hello world";
		System.out.println(str.indexOf('l'));
		System.out.println(str.indexOf("wo"));
		System.out.println(str.indexOf("w", 1));
		int index = 0;
		int count = 0;
		do {
			index = str.indexOf('d',index);
			if(index >= 0) {
				count++;
				index++;
			}		
		}while(index != -1);
		System.out.println("l의 개수 : " + count);
	}
}
