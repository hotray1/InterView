package cn.ot.Interview;

import java.lang.reflect.Field;
/**
 * 如何用反射来覆盖重写toString方法？
 * 用法：任意添加属性，都可以自动增加到toString方法中
 * 关键是：重写toString()方法
 * @author Administrator
 *
 */
public class PrivatePar {
	public static void main(String[] args) throws Exception {
	 Teacher tea = new Teacher("zhangshan",18,"男");
	 System.out.println(tea.toString());
	}
	
	 
}

class Teacher {
	public String name;
	int age;
	String sex;
	
	@Override
	public String toString() {
		Class clazz = this.getClass(); // 得到反射对象
		Field[] fd = clazz.getDeclaredFields(); // 得到所有的属性
		StringBuffer sb = new StringBuffer();
		for(Field f:fd) {
			
			try {
				sb.append(f.getName());
				sb.append(":");
				sb.append(f.get(this));
				sb.append(" ");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		
		return sb.toString();
	}
	public Teacher(String name, int age,String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}