package day17;

import java.util.*;

public class ExcSetBaseballEx1 {

	public static void main(String[] args) {
		List<Integer> com = new ArrayList<Integer>();
		Set<Integer> tmp = new HashSet<Integer>();
		
		int min = 1, max = 9;
		while(tmp.size() < 3) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean isAdd = tmp.add(r);
			if(isAdd) {
				com.add(r);
			}
		}
		System.out.println(tmp);	
		System.out.println(com);
	}

}
