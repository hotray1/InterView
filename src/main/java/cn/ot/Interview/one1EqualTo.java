package cn.ot.Interview;
/**
 * 用==比较String
 * @author Administrator
 *
 */
public class one1EqualTo {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		System.out.println(str1==str2);
		System.out.println(str3==str4);
		System.out.println(str1==str3);
	}
}
