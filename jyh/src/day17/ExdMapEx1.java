package day17;
import java.util.*;
public class ExdMapEx1 {

	public static void main(String[] args) {
		Map<String, String> userInfo = new HashMap<>();
		userInfo.put("abc123", "123123");
		userInfo.put("qwe123", "123123");
		userInfo.put("abc123", "123123123123");
		System.out.println(userInfo);
		userInfo.remove("abc123");
		System.out.println(userInfo);
		System.out.println(userInfo.get("qwe123"));
		System.out.println(userInfo.containsKey("qwe123"));

	}

}
