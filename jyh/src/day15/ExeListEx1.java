package day15;

import java.util.ArrayList;
import java.util.List;

public class ExeListEx1 {

	public static void main(String[] args) {
		//정수를 저장하는 List
		List<Integer> list1 = new ArrayList<Integer>();
		int arr1[] = new int[5];
		arr1[0] = 1;
		list1.add(1);
		arr1[1] = 2;
		list1.add(2);
		System.out.println(arr1[0]);
		//get() 은 리스트에만 있고, set은 없다.
		System.out.println(list1.get(0));
		System.out.println("배열의 크기 : " + arr1.length);
		System.out.println("list1에 저장된 갯수" + list1.size());
		System.out.println(list1);
		//remove(Object obj) : obj와 일치하는 객체를 제거한 후 제거한 객체를 알려줌
		//remove(int index)	 : index 번지에 있는 객체를 제거한 후 제거한 객체를 알려줌
		list1.remove((Integer)1);
		System.out.println(list1);
		list1.add(5);
		list1.add(15);
		list1.add(25);
		list1.add(35);
		list1.add(45);
		list1.add(55);
		System.out.println(list1);
		//contains : 리스트에 객체와 일치하는 객체가 있는지 알려줌
		System.out.println("5가 리스트에 있나요? : " + list1.contains(5));
		System.out.println("1이 리스트에 있나요? : " + list1.contains(1));
		//indexOf : 리스트에 객체와 일치하는 객체가 있으면 몇번지인지 알려줌 // 없으면 -1
		System.out.println("5가 리스트에 있나요? : " + list1.indexOf(5));
		System.out.println("1이 리스트에 있나요? : " + list1.indexOf(1));
		
	}

}
