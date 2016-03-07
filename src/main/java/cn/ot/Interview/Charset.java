package cn.ot.Interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Charset {
	public static void main(String[] args) {
		
		// 迭代器	
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
}
}
