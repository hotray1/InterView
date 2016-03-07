package cn.ot.Interview;
/**
 * String类用=赋值
 * @author Administrator
 *
 */
public class twoString {
	public static void change(String str) {
		str = "abc";
	}
	public static void main(String[] args) {
		String str = "123";
		change(str);
		System.out.println(str);
	}
}
