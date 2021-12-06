package day10;

import java.util.Scanner;

public class ClassBoardEx1 {

	public static void main(String[] args) {
		Board [] boardList = new Board[10];
		int menu = 0;
		int count = 0; // 현재까지 저장된 게시글 갯수
		Scanner scan = new Scanner(System.in);
		do {
			
			menu = printMenu(scan);
			//입력받은 메뉴에 따른 기능을 실행
			String title, contents, writer, date;
			int num;
			switch(menu) {
			case 1: 
				scan.nextLine(); //메뉴에서 입력된 엔터를 처리
				System.out.print("게시글 제목 : ");
				title = scan.nextLine();
				//위에서 입력한 엔터를 처리
				System.out.print("게시글 내용 : ");
				contents = scan.nextLine();
				System.out.print("게시글 작성자 : ");
				writer = scan.nextLine();
				System.out.print("게시글 작성일 : ");
				date = scan.nextLine();
				boardList[count] = new Board(title, contents, date, writer, count+1);
				count++;
				break;
			case 2:
				System.out.print("조회할 게시글 번호 : ");
				num = scan.nextInt();
				if(num <= count) {
					//삭제된 게시물인지 확인여부 후 삭제되었으면 삭제되었습니다. 출력
					if(boardList[num-1] == null) {
						System.out.println("삭제된 게시글입니다.");
					}
					else {
					boardList[num-1].updateViews();	//조회수 증가
					boardList[num-1].print();		//게시글 조회
					}
				}
				break;
			case 3:
				
				System.out.print("게시글 번호 : ");
				num = scan.nextInt();
				scan.nextLine(); //게시글 번호에서 입력한 엔터를 처리
				if(boardList[num-1] == null) {
					System.out.println("삭제된 게시글은 수정할 수 없습니다.");
				}
				else {
					System.out.print("게시글 제목 : ");
					title = scan.nextLine();
					System.out.print("게시글 내용 : ");
					contents = scan.nextLine();
					if(num <= count) {
						boardList[num-1].modify(title, contents);
					}
				}
				break;
			case 4:
				System.out.println("게시글 번호 : ");
				num = scan.nextInt();
				scan.nextLine();
				if(num <= count) {
					boardList[num-1] = null;
					
				}
				break;
			case 5: 
				break;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
			
		}while(menu != 5);//메뉴가 5번일때 반복문 종료
		System.out.println("프로그램을 종료합니다.");
	}
	
	/* 메뉴 출력하고 메뉴번호를 알려주는 메소드
	 * 매개변수 : Scanner (입력받기 위해서)
	 * 리턴타입 : 메뉴 번호 정수 = int 
	 * 메소드명 : printMenu*/
	public static int printMenu(Scanner scan) {
		System.out.println("[메뉴]");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요(1~5) : ");
		int menu = scan.nextInt();
		return menu;
	}
}
