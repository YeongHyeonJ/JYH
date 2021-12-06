package day16;

import java.util.ArrayList;
import java.util.Iterator;

public class ExaListIteratorEx1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);	list.add(2);	list.add(3);	list.add(4);
		//list는 get(번지)가 있기 때문에 반복문으로 값들을 확인할 수 있다.
		//set은 get(번지)가 없기 때문에 반복문을 그냥 이용할 수 없고, iterator를 이용해야 한다.
		for(int i = 0; i< list.size(); i++) {
			System.out.print(list.get((int)i) + (i == list.size()-1?"\n" : ", "));
		}
		Iterator<Integer> it = list.iterator();
		int count = 0;
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + (count == list.size()-1? "\n" : ", "));
			count++;
		}

	}

}
