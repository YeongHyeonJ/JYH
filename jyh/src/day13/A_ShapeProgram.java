package day13;

import java.util.Scanner;

public class A_ShapeProgram {

	public static void main(String[] args) {
		int menu = 0;
		Scanner scan = new Scanner(System.in);
		A_ShapeDraw draw = new A_ShapeDraw(10,scan);
		do {
			
			menu = printMenu(scan);
			switch(menu) {
			case 1: draw.insertSahpe();				
				break;
			case 2: draw.againShape();
				break;
			case 3: draw.cancelShape();
				break;
			case 4: draw.displayShape();				
				break;
			case 5: 
				break;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.");
			}
			
		}while(menu != 5);
		System.out.println("프로그램을 종료합니다.");

	}
	
	public static int printMenu(Scanner scan) {
		System.out.println("[메뉴]");
		System.out.println("1. 도형그리기");
		System.out.println("2. 다시 실행");
		System.out.println("3. 실행 취소");
		System.out.println("4. 도형 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요([1]~[5]) : ");
		int menu = scan.nextInt();
		System.out.println(menu);
		return menu;
	}
	
}
