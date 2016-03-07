package ch11;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.xml.transform.Result;

import com.mysql.jdbc.*;

public class TranTest {
	public static void main(String[] args) throws Exception {
		// 加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn =null;
		java.sql.Statement st = null;
		try {
			// 创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "sa");
			conn.setAutoCommit(false); // 关闭自动提交
			// 申明方法
			st = conn.createStatement();
			// 执行语句
			st.executeUpdate("UPDATE mname SET name='lishi' WHERE id=1");
			// 提交数据
			conn.commit(); 
			
		} catch (Exception e) {
			conn.rollback(); // 操作数据库错误时，则回滚
		} finally {
			// 关闭
			st.close();
			conn.close();
			
		}
	}
}
