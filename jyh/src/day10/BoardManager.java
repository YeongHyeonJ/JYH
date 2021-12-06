package day10;

import java.util.Scanner;

public class BoardManager {
	private Board [] boardList ;
	private int count;
	private static Scanner scan;
	
	public BoardManager() {
		this(10,scan);
		//boardList = new Board[10];
		//this.scan = scan;
	}
	public BoardManager(int size,Scanner scan) {
		this.scan = scan;
		if(size > 10) {
			boardList = new Board[size];
		}else {
			boardList = new Board[10];
		}
	}
	//게시글 등록 기능
	public void insertBoard() {
		scan.nextLine(); //메뉴에서 입력된 엔터를 처리
		System.out.print("게시글 제목 : ");
		String title = scan.nextLine();
		//위에서 입력한 엔터를 처리
		System.out.print("게시글 내용 : ");
		String contents = scan.nextLine();
		System.out.print("게시글 작성자 : ");
		String writer = scan.nextLine();
		System.out.print("게시글 작성일 : ");
		String date = scan.nextLine();
		boardList[count] = new Board(title, contents, date, writer, count+1);
		count++;
	}
	//게시글 조회 기능
	public void displayBoard(){
		System.out.print("조회할 게시글 번호 : ");
		int num = scan.nextInt();
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
	}
	//게시글 수정 기능
	public void modifyBoard() {
		System.out.print("게시글 번호 : ");
		int num = scan.nextInt();
		scan.nextLine(); //게시글 번호에서 입력한 엔터를 처리
		if(boardList[num-1] == null) {
			System.out.println("삭제된 게시글은 수정할 수 없습니다.");
		}
		else {
			System.out.print("게시글 제목 : ");
			String title = scan.nextLine();
			System.out.print("게시글 내용 : ");
			String contents = scan.nextLine();
			if(num <= count) {
				boardList[num-1].modify(title, contents);
			}
		}
	}
	//게시글 삭제 기능
	public void deleteBoard() {
		System.out.println("게시글 번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		if(num <= count) {
			boardList[num-1] = null;
			
		}
	}
}
