package cn.ot.Interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Collections {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		for(String str: list){
			System.out.println(str);
		}
	}
}

class Student {
	String name;
	int age;
	
	Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	private Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
