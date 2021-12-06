package day10;

import java.util.Scanner;

public class ClassBoardEx2 {

	public static void main(String[] args) {
		String menu = "0";
		Scanner scan = new Scanner(System.in);
		BoardManager bm = new BoardManager(10,scan) ;
		do {
			
			menu = printMenu(scan);
			//입력받은 메뉴에 따른 기능을 실행
			String num;
			switch(menu) {
			case "[1]": bm.insertBoard();				
				break;
			case "[2]": bm.displayBoard();
				break;
			case "[3]": bm.modifyBoard();
				break;
			case "[4]": bm.deleteBoard();				
				break;
			case "[5]": 
				break;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
			
		}while(menu != "[5]");//메뉴가 5번일때 반복문 종료
		System.out.println("프로그램을 종료합니다.");
	}
	
	/* 메뉴 출력하고 메뉴번호를 알려주는 메소드
	 * 매개변수 : Scanner (입력받기 위해서)
	 * 리턴타입 : 메뉴 번호 정수 = int 
	 * 메소드명 : printMenu*/
	public static String printMenu(Scanner scan) {
		System.out.println("[메뉴]");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요(1~5) : ");
		String menu = scan.next();
		System.out.println(menu);
		return menu;
	}
}
