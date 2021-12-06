package day15;

import java.util.*;

public class ExeListEx3 {

	public static void main(String[] args) {
		ArrayList<String> todolist1 = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		for(int i = 0 ; i < 5 ; i ++ ) {
			System.out.print("오늘의 할일 : ");
			String tmp = scan.nextLine();
			todolist1.add(tmp);
		}
		System.out.println(todolist1);
		
		scan.close();
	}
}
