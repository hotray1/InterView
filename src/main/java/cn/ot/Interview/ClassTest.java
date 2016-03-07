package cn.ot.Interview;

import java.lang.reflect.Method;
/**
 * 不创建实例 new Users("zhangs",18);来调用反射方法
 * 
 * @author Administrator
 *
 */
public class ClassTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// 获得反射对象
		Class uClass = Users.class;

		
		try {
			// 调用默认的构造方法
			Object obj = uClass.newInstance();
			// 获得方法对象
			Method method = uClass.getMethod("show");
			// 执行反射对象中方法
			method.invoke(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

// Users 对象
class Users {
	
	public String name;
	public int age;
	
	Users(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	// 显示方法
	static public void show() { // 静态方法是根据类名直接调用
		System.out.println("show.......");
	}
	
	
	
}
