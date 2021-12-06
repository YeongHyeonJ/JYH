package day17;

import java.util.*;

public class ExaLottoEx1 {

	public static void main(String[] args) {
		/* 로또 프로그램 만들기 */
		Scanner scan = new Scanner(System.in);
		List<Integer> com = new ArrayList<Integer>();
		List<Integer> use = new ArrayList<Integer>();
		int bonus = 0;
		int min = 1, max = 45;
		int count = 6, total = 0;
		char ch = 'y';
		// 숫자 6개 만들기

		ExeBaseBallEx2.createRandomList(com, min, max, count);

		// 보너스 랜덤번호가 저장된 list의 6개 숫자와 겹치지 않으면 보너스 번호 생성
		while (true) {
			bonus = (int) (Math.random() * (max - min + 1) + min);
			if (!com.contains(bonus)) {
				break;
			}
		}
		System.out.print(com);
		System.out.println(" : " + bonus);

		// 사용자 번호 6개 입력 만들기
		while (ch == 'y' || ch == 'Y') {
			System.out.println("입력 : ");
			int inputResult = ExeBaseBallEx2.inputList(use, min, max, count, scan);
			switch (inputResult) {
			case -1:
				System.out.println("중복된 값을 입력했습니다.");
				break;
			
			case 1:
				System.out.println("잘못된 범위의 정수를 입력했습니다.");
				break;

			}

			// 숫자6개와 보너스 번호와 사용자번호를 비교하여 같은숫자 있는지 확인하기
			total = ExeBaseBallEx2.getBall(com, use) + ExeBaseBallEx2.getStrike(com, use);
			// 당첨 개수에 따른 등수 표시 출력
			switch (total) {
			case 6:
				System.out.println("1등 당첨");
				break;
			case 5:
				if (com.contains(bonus)) {
					System.out.println("2등 당첨");
				} else {
					System.out.println("3등 당첨");
				}
				break;
			case 4:
				System.out.println("4등 당첨");
				break;
			case 3:
				System.out.println("5등 당첨");
				break;
			default:
				System.out.println("꽝");
			}

			System.out.println("더하시겠습니까?(y/n) : ");
			ch = scan.next().charAt(0);
		}
		System.out.println("프로그램 종료");
	}

}
