package day9;

public class MethodParameterEx1 {

	public static void main(String[] args) {
		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1,2,3,4));
		System.out.println(sum(9,19));
		//System.out.println(sum2()); //에러 발생 : 매개변수가 없어서
		System.out.println(sum2(new int[] {1,2}));
		printInfo(1, 1, 1, "홍길동", "홍길동", "활빈당", "영웅");
		printInfo(1, 1, 2, "임꺽정", "임꺽정", "도둑", "의적");
		
	}
	
	public static int sum(int ...nums) {
		int sum = 0;
		for(int i = 0; i<nums.length ; i++) {
			sum = sum + nums[i];
		}
		return sum;
	}
	public static int sum2(int []nums) {
		int sum = 0;
		for(int i = 0; i<nums.length ; i++) {
			sum += nums[i];
		}
		return sum;
	}
	
	public static void printInfo(int grade, int classNum , int num , String name, String ...nicknames) {
		System.out.println("학년 : " + grade);
		System.out.println("반  : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		System.out.print("별명 : ");
		for(int i = 0 ; i<nicknames.length; i++) {
			System.out.print(nicknames[i] + " ");
		}
		System.out.println();
		
		
	}

	/*public static void printInfo2(int grade, int classNum , int num , String ...nicknames ,String name ) {
		
	}
	*/
}
