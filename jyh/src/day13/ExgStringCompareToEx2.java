package day13;

public class ExgStringCompareToEx2 {

	public static void main(String[] args) {
		//문자열 3개를 한곳에 저장할 수 있도록 코드작성
		String [] arr = new String[4];
		arr[0] = "b";
		arr[1] = "d";
		arr[2] = "a";
		arr[3] = "c";
		for(int i = 0 ; i < arr.length-1 ; i ++) {		
			for(int j = 0; j < arr.length-1 ; j++) {
				if(arr[j].compareTo(arr[j+1]) > 0) {
					String tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(String tmp : arr) {
			System.out.print(tmp + " ");
		}		
	}
}
