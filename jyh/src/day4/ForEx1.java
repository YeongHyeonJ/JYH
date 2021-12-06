package day4;

public class ForEx1 {

	public static void main(String[] args) {
		int i ;
		for( i = 1 ; i <=5 ; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("int변수 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int변수 최소값 : " + Integer.MIN_VALUE);
		
		int maxNum = Integer.MAX_VALUE + 1; // 오버플로우
		int minNum = Integer.MIN_VALUE - 1; // 언더플로우
		System.out.println("int변수 최대값 : " + maxNum);
		System.out.println("int변수 최소값 : " + minNum);
	}

}
