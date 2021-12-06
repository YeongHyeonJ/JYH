package day17;

import java.util.*;

public class ExeBaseBallEx2 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크를 이용하여 숫자야구 게임을 구현 */
		Scanner scan = new Scanner(System.in);
		List<Integer> com = new ArrayList<Integer>();
		List<Integer> use = new ArrayList<Integer>();
		int min = 1, 	max = 9;
		int count = 3;
		int strike = 0, ball = 0;
	
		try {
			createRandomList(com, min, max, count);
		}catch(Exception e) {
			System.out.println("============================");
			System.out.println("예외발생!! : " + e.getMessage());
			System.out.println("============================");
			System.out.println("숫자 생성에 실패하여 실행할 수 없습니다.");
			return;
		}
		while(strike != count) {
			System.out.print("입력(ex : 1 2 3) : ");
			int inputResult = inputList(use, min, max, count, scan);
			switch (inputResult) {
			case -1: 
				System.out.println("중복된 값을 입력했습니다.");
				break;
			case 0: 	
				System.out.println(use);
				break;
			case 1: 	
				System.out.println("잘못된 범위의 정수를 입력했습니다.");
				break;
			
			}
			strike = getStrike(com, use);
			ball = getBall(com, use);
			printResult(strike, ball);
		}
		System.out.println("프로그램 종료");
		

	}

	public static void createRandomList(List<Integer> list, int min, int max, int count) {
		if (list == null) {
			// return;
			throw new NullPointerException("list가 null입니다.");
		}
		if (min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if (count > (max - min + 1)) {
			throw new RuntimeException("범위가 list의 크기보다 작아서 만들 수 없습니다.");
		}
		Set<Integer> comset = new HashSet<Integer>();
		while (comset.size() < count) {
			int r = (int) (Math.random() * (max - min + 1) + min);
			boolean isAdd = comset.add(r);
			if (isAdd) {
				list.add(r);
			}
		}
	}
	public static int inputList(List<Integer> list, int min, int max, int count, Scanner scan) {
		if(list == null) {
			throw new NullPointerException("list가 null입니다.");
		}
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > (max - min + 1)) {
			throw new RuntimeException("범위가 list의 크기보다 작아서 만들 수 없습니다.");
		}
		list.clear();
		int i = 0;
		boolean isOutOfBounds = false;
		Set<Integer> useset = new HashSet<Integer>();
		while (i < count) {
			int tmp = scan.nextInt();
			useset.add(tmp);
			list.add(tmp);
			isOutOfBounds = tmp >= min && tmp <= max ? isOutOfBounds : true;
			i++;
		}
		if(useset.size() != count) {
			return -1;
			
		}
		return isOutOfBounds ? 1:0;
	}
	public static int getStrike(List<Integer> list1, List<Integer> list2) {
		int strike = 0;
		for(int i = 0; i<list1.size() ; i++) {
			if(list1.get(i).equals(list2.get(i))) {
				strike++;
			}
		}
		return strike;
	}
	public static int getBall(List<Integer> list1, List<Integer> list2) {
		int ball = 0;
		for(int i = 0; i < list1.size() ; i++) {
			if(list1.contains(list2.get(i))) {
				ball++;
			}
		}
		ball = ball - getStrike(list1, list2);
		return ball;		
	}
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.println(strike + "S");
		}
		if(ball != 0 ) {
			System.out.println(ball + "B");
		}
		if(strike == 0 && ball ==0) {
			System.out.println("3O");
		}
		System.out.println();
	}

}
