package day6;

public class ArraySortEx1 {

	public static void main(String[] args) {
		int num [] = {1, 10, 9, 3, 6, 2, 3, 4};
		// 버블 정렬
		for(int i = 0; i < num.length-1 ; i++) {
			for(int j = 0; j < num.length-1 ; j++) {
				if(num[j] > num[j+1]) {
					int tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
				}
					
			}
		}
		for(int tmp : num) {
			System.out.print(tmp + " ");
		}
		
	}

}
