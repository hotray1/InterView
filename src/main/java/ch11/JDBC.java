package ch11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBC {
	public static void main(String[] args) throws Exception {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver"); 
		// 使用驱动管理器，获得连接
		Connection conn = DriverManager.getConnection("url");
		// 创建申明
		java.sql.Statement st = conn.createStatement();
		// 执行语句
		ResultSet rs = st.executeQuery("sql");
		
		// 获得结果
		rs.next();
		// 关闭连接
		rs.close();
		st.close();
		conn.close();
	}
}
