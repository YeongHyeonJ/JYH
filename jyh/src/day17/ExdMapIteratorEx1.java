package day17;
import java.util.*;
public class ExdMapIteratorEx1 {

	public static void main(String[] args) {
		/* Map에서 반복문 사용하는 예제*/
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa111", "1111");
		map.put("bbb222", "2222");
		map.put("ccc333", "3333");
		
		Set<String> set = map.keySet();
		System.out.println(set);
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println("ID : " + key + ", PW : " + value);
		}
	}

}
