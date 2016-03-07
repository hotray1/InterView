package ch11;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 
 * @author Administrator
 *
 */
public class DaoTest {
	static {
		try {
			Class.forName("com.mysql.JDBC.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getConn() throws Exception {
		// 获得连接
		java.sql.Connection conn = DriverManager.getConnection("", "root", "sa");
		// 申明
		java.sql.Statement st = conn.createStatement();
		// 执行sql 
		// 结果
		// 关闭
	}
	public static void main(String[] args) {
		
	}
}
class Box {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Box [id=" + id + ", name=" + name + "]";
	}
	private Box(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private Box() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}