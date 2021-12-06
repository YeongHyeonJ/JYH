package day17;

import java.util.*;
import java.util.Map.Entry;

public class ExdMapIteratorEx2 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa111", "1111");
		map.put("bbb222", "2222");
		map.put("ccc333", "3333");
		
		// entrySet() : key와 value를 맴버변수로 갖는 Entry 클래스가 있고
		// 				각 key와 value들을 Entry클래스의 객체로 바꾼후 Set에 담아서 알려줌.
		Set<Map.Entry<String, String>> set = map.entrySet();
		Iterator<Map.Entry<String, String>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> e = it.next();
			String key = e.getKey();
			String value = e.getValue();
			System.out.println("ID : " + key + ", PW : " + value);
		}
	}

}
